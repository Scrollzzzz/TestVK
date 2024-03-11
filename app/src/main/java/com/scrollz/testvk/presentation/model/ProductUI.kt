package com.scrollz.testvk.presentation.model

import androidx.compose.runtime.Immutable

@Immutable
data class ProductUI(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val discount: String,
    val rating: String,
    val brand: String,
    val images: List<String>
)
