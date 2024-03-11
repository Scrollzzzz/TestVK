package com.scrollz.testvk.domain.model

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Double,
    val rating: Double,
    val brand: String,
    val images: List<String>
)
