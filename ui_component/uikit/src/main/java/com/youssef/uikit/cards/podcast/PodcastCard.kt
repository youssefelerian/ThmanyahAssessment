package com.youssef.uikit.cards.podcast


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.youssef.ui_core.core.image.LoadImage
import com.youssef.ui_core.core.text.BodySText
import com.youssef.ui_core.core.text.LabelSBoldText
import com.youssef.ui_core.core.views.SpacerVertical
import com.youssef.ui_core.theme.AppTheme
import com.youssef.uikit.cards.podcast.model.PodcastUiModel

@Composable
fun PodcastCard(podcast: PodcastUiModel) {
    Card(
        shape = AppTheme.radius.radiusL,
        modifier = Modifier.width(AppTheme.spaces.space8Xl).padding(AppTheme.spaces.space2Xs)
    ) {
        Column {
            LoadImage(
                Modifier.size(AppTheme.spaces.space8Xl),
                podcast.imageUrl
            )
            SpacerVertical(AppTheme.spaces.spaceS)
            LabelSBoldText(
                text = podcast.title,
                isCenter = false,
                color = AppTheme.colors.textPrimary,
                maxLines = 1
            )
            SpacerVertical(AppTheme.spaces.space2Xs)
            BodySText(
                text = podcast.duration,
                isCenter = false,
                maxLines = 1
            )
        }
    }

}