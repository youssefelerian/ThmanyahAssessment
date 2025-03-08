package com.youssef.uikit.engine

import androidx.compose.runtime.Composable
import com.youssef.uikit.cards.audio_article.AudioArticleComponent
import com.youssef.uikit.cards.audio_article.model.AudioArticleUiModel
import com.youssef.uikit.cards.audio_book.AudioBookComponent
import com.youssef.uikit.cards.audio_book.model.AudioBookUiModel
import com.youssef.uikit.cards.episode.EpisodeComponent
import com.youssef.uikit.cards.episode.model.EpisodeUiModel
import com.youssef.uikit.cards.podcast.PodcastComponent
import com.youssef.uikit.cards.podcast.model.PodcastUiModel
import com.youssef.uikit.layout.big_square.BigSquareComponent
import com.youssef.uikit.layout.big_square.model.BigSquareUiModel
import com.youssef.uikit.layout.square.SquareComponent
import com.youssef.uikit.layout.square.model.SquareUiModel
import com.youssef.uikit.layout.two_row_grid.TowRowGridComponent
import com.youssef.uikit.layout.two_row_grid.model.TowRowGridUiModel
import com.youssef.uikit.ui_model.IRenderComponent
import com.youssef.uikit.ui_model.UIPros

object RenderEngin {
    fun getComponent(props: UIPros): IRenderComponent {
        return when (props) {
            is PodcastUiModel -> {
                PodcastComponent(props)
            }

            is EpisodeUiModel -> {
                EpisodeComponent(props)
            }

            is AudioBookUiModel -> {
                AudioBookComponent(props)
            }

            is AudioArticleUiModel -> {
                AudioArticleComponent(props)
            }

            is BigSquareUiModel -> {
                BigSquareComponent(props)
            }

            is SquareUiModel -> {
                SquareComponent(props)
            }

            is TowRowGridUiModel -> {
                TowRowGridComponent(props)
            }

            else -> {
                object : IRenderComponent {
                    @Composable
                    override fun Render() {
                    }

                }
            }
        }
    }
}