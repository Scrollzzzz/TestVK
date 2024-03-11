package com.scrollz.testvk.presentation.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.scrollz.testvk.domain.use_case.GetProductsUseCase
import com.scrollz.testvk.presentation.model.ProductUI
import com.scrollz.testvk.utils.AppDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val dispatchers: AppDispatchers
): ViewModel() {

    private val _state = MutableStateFlow(CatalogState())
    val state = _state.asStateFlow()

    private val _products = MutableStateFlow<PagingData<ProductUI>>(PagingData.empty())
    val products = _products.asStateFlow()

    private val _query = MutableStateFlow("")

    init {
        getProducts(_query.value)
        processQuery()
    }

    fun onEvent(event: CatalogEvent) {
        when (event) {
            is CatalogEvent.Retry -> getProducts(_query.value)
            is CatalogEvent.StartSearching -> _state.update { it.copy(isSearching = true) }
            is CatalogEvent.OnQueryChange -> _query.update { event.value }
            is CatalogEvent.ClearSearch -> _query.update { "" }
            is CatalogEvent.StopSearching -> {
                _state.update { it.copy(isSearching = false) }
                _query.update { "" }
            }
        }
    }

    @OptIn(FlowPreview::class)
    private fun processQuery() {
        _query
            .drop(1)
            .onEach { query -> _state.update { it.copy(queryText = query) } }
            .debounce(700)
            .distinctUntilChanged()
            .onEach { query -> getProducts(query) }
            .launchIn(viewModelScope)
    }

    private fun getProducts(query: String) {
        viewModelScope.launch(dispatchers.io) {
            getProductsUseCase(query).cachedIn(viewModelScope).collect {
                _products.value = it
            }
        }
    }

}
