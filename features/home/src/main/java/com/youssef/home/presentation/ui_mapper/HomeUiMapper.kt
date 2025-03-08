package com.youssef.home.presentation.ui_mapper

import androidx.compose.ui.unit.dp
import com.youssef.home.domain.entity.HomeEntity
import com.youssef.home.domain.entity.SectionEntity
import com.youssef.home.domain.entity.content.AudioArticleEntity
import com.youssef.home.domain.entity.content.AudioBookEntity
import com.youssef.home.domain.entity.content.EpisodeEntity
import com.youssef.home.domain.entity.content.PodcastEntity
import com.youssef.home.domain.entity.type.SectionType
import com.youssef.uikit.cards.audio_article.model.AudioArticleUiModel
import com.youssef.uikit.cards.audio_book.model.AudioBookUiModel
import com.youssef.uikit.cards.episode.model.EpisodeUiModel
import com.youssef.uikit.cards.podcast.model.PodcastUiModel
import com.youssef.uikit.engine.RenderEngin
import com.youssef.uikit.layout.big_square.model.BigSquareUiModel
import com.youssef.uikit.layout.square.model.SquareUiModel
import com.youssef.uikit.layout.two_row_grid.model.TowRowGridUiModel
import com.youssef.uikit.ui_model.IRenderComponent
import com.youssef.uikit.ui_model.UIPros


fun HomeEntity.toUiModel(): List<IRenderComponent> {
    return sections.map {
        val listOfComponent = it.content.map { content ->
            val props: UIPros = when (content) {
                is AudioArticleEntity -> {
                    AudioArticleUiModel(
                        content.name,
                        content.duration.toDuration(),
                        content.avatarUrl
                    )
                }

                is AudioBookEntity -> {
                    AudioBookUiModel(content.name, content.duration.toDuration(), content.avatarUrl)
                }

                is EpisodeEntity -> {
                    EpisodeUiModel(content.name, content.duration.toDuration(), content.avatarUrl)
                }

                is PodcastEntity -> {
                    PodcastUiModel(content.name, content.duration.toDuration(), content.avatarUrl)
                }
            }
            RenderEngin.getComponent(props)
        }
        it.toUiModel(listOfComponent)
    }
}

fun SectionEntity.toUiModel(listOfComponent: List<IRenderComponent>): IRenderComponent {
    val props: UIPros = when (type) {
        SectionType.SQUARE -> {
            SquareUiModel(
                title = name,
                height = 150.dp,
                componentList = listOfComponent
            )
        }

        SectionType.TWO_LINES_GRID -> {
            TowRowGridUiModel(
                title = name,
                height = 150.dp,
                componentList = listOfComponent
            )
        }

        SectionType.BIG_SQUARE -> {
            BigSquareUiModel(
                title = name,
                height = 150.dp,
                componentList = listOfComponent
            )
        }

        SectionType.QUEUE -> {
            SquareUiModel(
                title = name,
                height = 150.dp,
                componentList = listOfComponent
            )
        }

        SectionType.BIG_SQUARE_2 -> {
            BigSquareUiModel(
                title = name,
                height = 150.dp,
                componentList = listOfComponent
            )
        }
    }
    return RenderEngin.getComponent(props)
}

fun Int.toDuration(): String {
    val minutes = this / 60
    val seconds = this % 60
    return String.format("%02d:%02d", minutes, seconds)
}


