package com.youssef.uikit.cards.audio_article

import androidx.compose.runtime.Composable
import com.youssef.uikit.cards.audio_article.model.AudioArticleUiModel
import com.youssef.uikit.ui_model.IRenderComponent

class AudioArticleComponent(private val props: AudioArticleUiModel) : IRenderComponent {
    @Composable
    override fun Render() {
        AudioArticleCard(props)
    }
}