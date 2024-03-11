package com.scrollz.testvk.presentation.catalog.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PointerRow(
    modifier: Modifier = Modifier,
    count: Int,
    selected: Int,
    pointerSize: Dp
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until count) {
            Pointer(
                modifier = Modifier
                    .padding(2.dp)
                    .size(pointerSize),
                selected = i == selected
            )
        }
    }
}

@Composable
fun Pointer(
    modifier: Modifier = Modifier,
    selected: Boolean
) {
    val color by animateColorAsState(
        targetValue = if (selected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.secondary,
        animationSpec = tween(200),
        label = "pointerColor"
    )

    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = color
    ) {}
}
