package com.youssef.uikit.cards.episode

import androidx.compose.runtime.Composable
import com.youssef.uikit.cards.episode.model.EpisodeUiModel
import com.youssef.uikit.ui_model.IRenderComponent

class EpisodeComponent(private val props: EpisodeUiModel) : IRenderComponent {
    @Composable
    override fun Render() {
        if (props.isBig)
            BigEpisodeCard(props)
        else
            EpisodeCard(props)
    }
}