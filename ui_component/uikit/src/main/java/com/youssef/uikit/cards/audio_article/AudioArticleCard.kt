package com.youssef.uikit.cards.audio_article


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.youssef.ui_core.core.image.LoadImage
import com.youssef.ui_core.core.text.BodySText
import com.youssef.ui_core.core.text.LabelSBoldText
import com.youssef.ui_core.core.views.SpacerVertical
import com.youssef.ui_core.theme.AppTheme
import com.youssef.uikit.cards.audio_article.model.AudioArticleUiModel

@Composable
fun AudioArticleCard(model: AudioArticleUiModel) {
    Card(
        shape = AppTheme.radius.radiusL,
        modifier = Modifier.size(AppTheme.spaces.space8Xl)
    ) {
        Column {
            LoadImage(
                Modifier.size(AppTheme.spaces.space8Xl),
                model.imageUrl
            )
            SpacerVertical(AppTheme.spaces.spaceS)
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
        }
    }

}