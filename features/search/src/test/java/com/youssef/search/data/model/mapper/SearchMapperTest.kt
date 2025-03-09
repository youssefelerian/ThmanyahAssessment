package com.youssef.search.data.model.mapper


import com.youssef.search.data.model.content.ContentResponse
import org.junit.Assert.assertEquals
import org.junit.Test

class SearchMapperTest {


    @Test
    fun `AContentResponse toEntity maps correctly`() {
        val contentResponse = ContentResponse(
            podcast_id = "podcastId",
            name = "Podcast Name",
            description = "Description",
            avatar_url = "Avatar URL",
            episode_count = "10",
            duration = "600",
            priority = "1",
            popularityScore = "100",
            score = "4.5"
        )

        val result = contentResponse.toEntity()

        assertEquals("podcastId", result.podcastId)
        assertEquals("Podcast Name", result.name)
    }

}