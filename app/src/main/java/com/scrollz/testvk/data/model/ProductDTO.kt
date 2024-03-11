package com.scrollz.testvk.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductDTO(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "price")
    val price: Int,
    @Json(name = "discountPercentage")
    val discountPercentage: Double,
    @Json(name = "rating")
    val rating: Double,
    @Json(name = "stock")
    val stock: Int,
    @Json(name = "brand")
    val brand: String,
    @Json(name = "category")
    val category: String,
    @Json(name = "thumbnail")
    val thumbnail: String,
    @Json(name = "images")
    val images: List<String>
)
