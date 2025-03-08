package com.youssef.uikit.cards.audio_book

import androidx.compose.runtime.Composable
import com.youssef.uikit.cards.audio_book.model.AudioBookUiModel
import com.youssef.uikit.ui_model.IRenderComponent

class AudioBookComponent(private val props: AudioBookUiModel) : IRenderComponent {
    @Composable
    override fun Render() {
        if (props.isBig)
            BigAudioBookCard(props)
        else
            AudioBookCard(props)
    }
}