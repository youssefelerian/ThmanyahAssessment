package com.youssef.search.presentation.ui_mapper


import com.youssef.search.domain.entity.SearchEntity
import com.youssef.search.domain.entity.SectionEntity
import com.youssef.search.domain.entity.content.ContentEntity
import com.youssef.search.domain.entity.type.ContentType
import com.youssef.search.domain.entity.type.SectionType
import com.youssef.uikit.layout.big_square.BigSquareComponent
import com.youssef.uikit.layout.square.SquareComponent
import org.junit.Assert.assertEquals
import org.junit.Test

class SearchUiMapperTest {

    @Test
    fun `toUiModel should map SearchEntity to list of IRenderComponent`() {
        val sectionEntity = SectionEntity(
            type = SectionType.SQUARE, name = "Section 1", content = listOf(
                ContentEntity("id", "name", "author", "description", "url", "3600", "", "1", "1"),
                ContentEntity("id", "name", "author", "description", "url", "3600", "", "", "1"),
            ), order = "1", contentType = ContentType.AUDIO_ARTICLE
        )
        val searchEntity = SearchEntity(sections = listOf(sectionEntity))

        val result = searchEntity.toUiModel()

        assertEquals(1, result.size)
        val sectionComponent = result[0] as SquareComponent
        assertEquals("Section 1", sectionComponent.props.title)
        assertEquals(2, sectionComponent.props.componentList.size)
    }

    @Test
    fun `toUiModel should handle empty sections`() {
        val searchEntity = SearchEntity(sections = emptyList())

        val result = searchEntity.toUiModel()

        assertEquals(0, result.size)
    }

    @Test
    fun `toUiModel should handle different SectionTypes`() {
        val sectionEntity = SectionEntity(
            type = SectionType.BIG_SQUARE, name = "Section 2", content = listOf(
                ContentEntity("id", "name", "description", "url", "1", "1", "1", "1", "1.5")
            ), order = "1", contentType = ContentType.PODCAST
        )
        val searchEntity = SearchEntity(sections = listOf(sectionEntity))

        val result = searchEntity.toUiModel()

        assertEquals(1, result.size)
        val sectionComponent = result[0] as BigSquareComponent
        assertEquals("Section 2", sectionComponent.props.title)
        assertEquals(1, sectionComponent.props.componentList.size)
    }
}