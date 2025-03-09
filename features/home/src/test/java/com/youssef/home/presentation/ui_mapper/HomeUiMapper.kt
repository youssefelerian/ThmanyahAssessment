package com.youssef.home.presentation.ui_mapper

import com.youssef.home.domain.entity.HomeEntity
import com.youssef.home.domain.entity.PaginationEntity
import com.youssef.home.domain.entity.SectionEntity
import com.youssef.home.domain.entity.content.AudioArticleEntity
import com.youssef.home.domain.entity.content.AudioBookEntity
import com.youssef.home.domain.entity.content.PodcastEntity
import com.youssef.home.domain.entity.type.ContentType
import com.youssef.home.domain.entity.type.SectionType
import com.youssef.uikit.layout.big_square.BigSquareComponent
import com.youssef.uikit.layout.square.SquareComponent
import org.junit.Assert.assertEquals
import org.junit.Test

class HomeUiMapperTest {

    @Test
    fun `toUiModel should map HomeEntity to list of IRenderComponent`() {
        val sectionEntity = SectionEntity(
            type = SectionType.SQUARE,
            name = "Section 1",
            content = listOf(
                AudioArticleEntity("id", "name", "author", "description", "url", 3600, "", 1),
                AudioBookEntity("id", "name", "author", "description", "url", 3600, "", "", 1),
            ), order = 1, contentType = ContentType.AUDIO_ARTICLE
        )
        val homeEntity =
            HomeEntity(sections = listOf(sectionEntity), pagination = PaginationEntity("1", 1))

        val result = homeEntity.toUiModel()

        assertEquals(1, result.size)
        val sectionComponent = result[0] as SquareComponent
        assertEquals("Section 1", sectionComponent.props.title)
        assertEquals(2, sectionComponent.props.componentList.size)
    }

    @Test
    fun `toUiModel should handle empty sections`() {
        val homeEntity = HomeEntity(sections = emptyList(), pagination = PaginationEntity("1", 1))

        val result = homeEntity.toUiModel()

        assertEquals(0, result.size)
    }

    @Test
    fun `toUiModel should handle different SectionTypes`() {
        val sectionEntity = SectionEntity(
            type = SectionType.BIG_SQUARE,
            name = "Section 2",
            content = listOf(
                PodcastEntity("id", "name", "description", "url", 1, 1, 1, 1, 1.5)
            ), order = 1, contentType = ContentType.PODCAST
        )
        val homeEntity =
            HomeEntity(sections = listOf(sectionEntity), pagination = PaginationEntity("1", 1))

        val result = homeEntity.toUiModel()

        assertEquals(1, result.size)
        val sectionComponent = result[0] as BigSquareComponent
        assertEquals("Section 2", sectionComponent.props.title)
        assertEquals(1, sectionComponent.props.componentList.size)
    }

    @Test
    fun `toDuration should format duration correctly`() {
        val duration = 125

        val result = duration.toDuration()

        assertEquals("02:05", result)
    }

    @Test
    fun `toDuration should handle zero duration`() {
        val duration = 0

        val result = duration.toDuration()

        assertEquals("00:00", result)
    }
}