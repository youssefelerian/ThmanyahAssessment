package com.youssef.search.presentation.ui_mapper

import androidx.compose.ui.unit.dp
import com.youssef.search.domain.entity.SearchEntity
import com.youssef.search.domain.entity.SectionEntity
import com.youssef.search.domain.entity.type.ContentType
import com.youssef.search.domain.entity.type.SectionType
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


fun SearchEntity.toUiModel(): List<IRenderComponent> {
    return sections.map { section ->
        val listOfComponent = section.content.map { content ->
            val props: UIPros = when (section.contentType) {
                ContentType.AUDIO_ARTICLE -> {
                    AudioArticleUiModel(
                        content.name,
                        content.duration,
                        content.avatarUrl
                    )
                }

                ContentType.AUDIO_BOOK -> {
                    AudioBookUiModel(
                        section.type == SectionType.BIG_SQUARE_2 || section.type == SectionType.BIG_SQUARE,
                        content.name,
                        content.duration,
                        content.avatarUrl
                    )
                }

                ContentType.EPISODE -> {
                    EpisodeUiModel(
                        section.type == SectionType.BIG_SQUARE_2 || section.type == SectionType.BIG_SQUARE,
                        content.name,
                        content.duration,
                        content.avatarUrl
                    )
                }

                ContentType.PODCAST -> {
                    PodcastUiModel(content.name, content.duration, content.avatarUrl)
                }
            }
            RenderEngin.getComponent(props)
        }
        section.toUiModel(listOfComponent)
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
                componentList = listOfComponent
            )
        }
    }
    return RenderEngin.getComponent(props)
}
