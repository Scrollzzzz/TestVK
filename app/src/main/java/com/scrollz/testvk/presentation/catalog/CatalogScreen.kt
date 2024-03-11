package com.scrollz.testvk.presentation.catalog

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.scrollz.testvk.presentation.catalog.components.ErrorItem
import com.scrollz.testvk.presentation.catalog.components.ErrorScreen
import com.scrollz.testvk.presentation.catalog.components.ProductCard
import com.scrollz.testvk.presentation.catalog.components.ProgressIndicator
import com.scrollz.testvk.presentation.catalog.components.TopBar

@Composable
fun CatalogScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = hiltViewModel<CatalogViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val products = viewModel.products.collectAsLazyPagingItems()

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = modifier,
            topBar = {
                TopBar(
                    isSearching = state.isSearching,
                    queryText = state.queryText,
                    startSearching = { viewModel.onEvent(CatalogEvent.StartSearching) },
                    onQueryChange = { viewModel.onEvent(CatalogEvent.OnQueryChange(it)) },
                    clearSearch = { viewModel.onEvent(CatalogEvent.ClearSearch) },
                    stopSearching = { viewModel.onEvent(CatalogEvent.StopSearching) }
                )
            }
        ) { paddingValues ->
            Crossfade(
                targetState = products.loadState.refresh,
                animationSpec = tween(300),
                label = "catalogBody"
            ) { loadState ->
                when (loadState) {
                    is LoadState.Loading -> {
                        ProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(paddingValues)
                                .height(0.5.dp),
                        )
                    }
                    is LoadState.Error -> {
                        ErrorScreen(
                            modifier = Modifier.fillMaxSize(),
                            retry = { viewModel.onEvent(CatalogEvent.Retry) }
                        )
                    }
                    is LoadState.NotLoading -> {
                        LazyVerticalGrid(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues),
                            columns = GridCells.Fixed(2),
                            contentPadding = PaddingValues(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(
                                count = products.itemCount,
                                key = products.itemKey { it.id },
                                contentType = products.itemContentType { "product" }
                            ) {index ->
                                products[index]?.let { product ->
                                    ProductCard(product = product)
                                }
                            }
                            footer(
                                loadState = products.loadState.append,
                                retry = { products.retry() }
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun LazyGridScope.footer(
    loadState: LoadState,
    retry: () -> Unit
) {
    if (loadState is LoadState.NotLoading) return

    item(
        key = "footer_item",
        span = { GridItemSpan(2) }
    ) {
        Crossfade(
            targetState = loadState,
            animationSpec = tween(300),
            label = "footer"
        ) { loadState ->
            when (loadState) {
                is LoadState.Loading -> {
                    ProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 35.5.dp)
                            .height(0.5.dp),
                    )
                }
                is LoadState.Error -> {
                    ErrorItem(
                        modifier = Modifier.fillMaxWidth(),
                        retry = retry
                    )
                }
                is LoadState.NotLoading -> { }
            }
        }
    }
}
