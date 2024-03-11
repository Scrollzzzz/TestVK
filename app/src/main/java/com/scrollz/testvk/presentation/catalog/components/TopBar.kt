package com.scrollz.testvk.presentation.catalog.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.scrollz.testvk.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    isSearching: Boolean,
    queryText: String,
    startSearching: () -> Unit,
    onQueryChange: (String) -> Unit,
    clearSearch: () -> Unit,
    stopSearching: () -> Unit
) {
    Crossfade(
        targetState = isSearching,
        animationSpec = tween(300),
        label = "topBar"
    ) { searching ->
        if (searching) {
            SearchRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                queryText = queryText,
                onQueryChange = onQueryChange,
                clearSearch = clearSearch,
                stopSearching = stopSearching
            )
        } else {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    scrolledContainerColor = MaterialTheme.colorScheme.background,
                    navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
                    actionIconContentColor = MaterialTheme.colorScheme.onBackground,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                ),
                actions = {
                    IconButton(
                        onClick = startSearching
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription = stringResource(R.string.search)
                        )
                    }
                }
            )
        }
    }
}
