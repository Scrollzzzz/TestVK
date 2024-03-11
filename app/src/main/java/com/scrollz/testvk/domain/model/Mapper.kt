package com.scrollz.testvk.domain.model

import com.scrollz.testvk.data.model.ProductDTO

fun ProductDTO.toProduct() = Product(
    id = id,
    title = title,
    description = description,
    price = price,
    discountPercentage = discountPercentage,
    rating = rating,
    brand = brand,
    images = buildList {
        add(thumbnail)
        addAll(images)
    }
)
