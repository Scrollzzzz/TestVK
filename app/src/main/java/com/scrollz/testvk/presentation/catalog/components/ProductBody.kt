package com.scrollz.testvk.presentation.catalog.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.scrollz.testvk.R

@Composable
fun ProductBody(
    modifier: Modifier = Modifier,
    price: String,
    rating: String,
    brand: String,
    title: String,
    description: String
) {
    Row(
        modifier = modifier
    ) {
        Text(
            text = price,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Icon(
            modifier = Modifier.size(15.dp),
            painter = painterResource(R.drawable.star),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.inversePrimary
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = rating,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
    Spacer(modifier = Modifier.height(6.dp))
    Text(
        modifier = modifier,
        text = brand,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.onBackground
    )
    Text(
        modifier = modifier,
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onBackground
    )
    Spacer(modifier = Modifier.height(6.dp))
    Text(
        modifier = modifier,
        text = description,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.tertiary
    )
}
