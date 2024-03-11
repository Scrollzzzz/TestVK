package com.scrollz.testvk.presentation.model

import com.scrollz.testvk.domain.model.Product

fun Product.toProductUI() = ProductUI(
    id = id,
    title = title,
    description = description,
    price = "$price \$",
    discount = "-$discountPercentage%",
    rating = rating.toString(),
    brand = brand,
    images = images
)
