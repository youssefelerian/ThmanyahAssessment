package com.youssef.uikit.cards.episode


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.youssef.ui_core.core.image.LoadImage
import com.youssef.ui_core.core.text.BodySText
import com.youssef.ui_core.core.text.LabelSBoldText
import com.youssef.ui_core.core.views.SpacerHorizontal
import com.youssef.ui_core.core.views.SpacerVertical
import com.youssef.ui_core.theme.AppTheme
import com.youssef.uikit.cards.episode.model.EpisodeUiModel

@Composable
fun EpisodeCard(model: EpisodeUiModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        LoadImage(
            Modifier.size(AppTheme.spaces.space8Xl),
            model.imageUrl
        )
        SpacerHorizontal(AppTheme.spaces.spaceS)
        Column {
            LabelSBoldText(
                text = model.title,
                isCenter = false,
                color = AppTheme.colors.textPrimary,
                maxLines = 2
            )
            SpacerVertical(AppTheme.spaces.space2Xs)
            BodySText(
                text = model.duration,
                isCenter = false,
                maxLines = 1
            )
        }
    }
}

@Composable
fun BigEpisodeCard(model: EpisodeUiModel) {
    Box(
        modifier = Modifier
            .height(AppTheme.spaces.space150)
            .width(AppTheme.spaces.spaceHeightBig)
    ) {
        LoadImage(
            Modifier
                .height(AppTheme.spaces.space150)
                .width(AppTheme.spaces.spaceHeightBig),
            model.imageUrl
        )
        Column(
            modifier = Modifier
                .padding(AppTheme.spaces.spaceS6)
                .align(Alignment.BottomStart)
        ) {
            LabelSBoldText(
                text = model.title,
                isCenter = false,
                color = AppTheme.colors.textPrimary,
                maxLines = 1
            )
            SpacerVertical(AppTheme.spaces.space2Xs)
            BodySText(
                text = model.duration,
                isCenter = false,
                maxLines = 1
            )
            SpacerVertical(AppTheme.spaces.space5Xl)
        }
    }

}