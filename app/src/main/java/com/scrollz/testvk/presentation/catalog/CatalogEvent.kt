package com.scrollz.testvk.presentation.catalog

sealed class CatalogEvent {
    data object StartSearching: CatalogEvent()
    data object StopSearching: CatalogEvent()
    data object ClearSearch: CatalogEvent()
    data class OnQueryChange(val value: String): CatalogEvent()
    data object Retry: CatalogEvent()
}
