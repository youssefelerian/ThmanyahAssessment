package com.youssef.uikit.cards.podcast

import androidx.compose.runtime.Composable
import com.youssef.uikit.cards.podcast.model.PodcastUiModel
import com.youssef.uikit.ui_model.IRenderComponent

class PodcastComponent(private val props: PodcastUiModel) : IRenderComponent {
    @Composable
    override fun Render() {
        PodcastCard(props)
    }
}