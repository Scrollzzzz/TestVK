package com.scrollz.testvk.presentation.catalog.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.scrollz.testvk.presentation.model.ProductUI

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: ProductUI
) {
    Card(
        modifier = modifier.heightIn(min = 300.dp),
        onClick = {},
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            disabledContainerColor = MaterialTheme.colorScheme.background,
            disabledContentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        ImagePager(
            modifier = Modifier.fillMaxWidth(),
            images = product.images
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProductBody(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            price = product.price,
            rating = product.rating,

            brand = product.brand,
            title = product.title,
            description = product.description
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}
