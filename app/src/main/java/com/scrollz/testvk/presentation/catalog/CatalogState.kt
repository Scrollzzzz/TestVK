package com.scrollz.testvk.presentation.catalog

import androidx.compose.runtime.Immutable

@Immutable
data class CatalogState(
    val isSearching: Boolean = false,
    val queryText: String = ""
)
