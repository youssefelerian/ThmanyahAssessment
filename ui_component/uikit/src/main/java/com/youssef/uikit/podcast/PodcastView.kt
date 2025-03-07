package com.youssef.uikit.podcast


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.youssef.ui_core.core.image.LoadImage
import com.youssef.ui_core.core.text.BodyMText
import com.youssef.ui_core.core.text.BodySText
import com.youssef.ui_core.core.views.SpacerVertical
import com.youssef.ui_core.theme.AppTheme

@Composable
fun PodcastView(imageUrl: String, title: String) {
    Column(modifier = Modifier.width(AppTheme.spaces.space8Xl)) {
        LoadImage(
            Modifier.size(AppTheme.spaces.space8Xl),
            imageUrl
        )
        SpacerVertical(AppTheme.spaces.spaceL)
        BodySText(
            text = title,
            isCenter = false,
            color = AppTheme.colors.textPrimary,
            maxLines = 1
        )
    }
}