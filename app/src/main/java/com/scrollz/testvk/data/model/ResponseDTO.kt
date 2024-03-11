package com.scrollz.testvk.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseDTO(
    @Json(name = "products")
    val products: List<ProductDTO>,
    @Json(name = "total")
    val total: Int,
    @Json(name = "skip")
    val skip: Int,
    @Json(name = "limit")
    val limit: Int
)
