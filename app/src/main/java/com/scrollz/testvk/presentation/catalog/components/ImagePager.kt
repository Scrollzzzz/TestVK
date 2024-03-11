package com.scrollz.testvk.presentation.catalog.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun ImagePager(
    modifier: Modifier = Modifier,
    images: List<String>
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { images.size })

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .height(144.dp)
                .clip(RoundedCornerShape(8.dp)),
            state = pagerState,
            key = { images[it] }
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(images[it])
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                error = BrushPainter(SolidColor(MaterialTheme.colorScheme.surface))
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        PointerRow(
            modifier = Modifier,
            count = pagerState.pageCount,
            selected = pagerState.currentPage,
            pointerSize = 4.dp
        )
    }
}
