package com.scrollz.testvk.presentation.catalog.components

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap

@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier
) {
    LinearProgressIndicator(
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary,
        trackColor = MaterialTheme.colorScheme.background,
        strokeCap = StrokeCap.Round
    )
}
