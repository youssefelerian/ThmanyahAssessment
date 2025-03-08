package com.youssef.ui_core.core.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.youssef.ui_core.theme.AppTheme

@Composable
fun LoadImage(modifier: Modifier, url: String) {
    AsyncImage(
        modifier = modifier.clip(AppTheme.radius.radiusL),
        model = url,
        contentScale = ContentScale.FillBounds,
        contentDescription = null,
    )
}