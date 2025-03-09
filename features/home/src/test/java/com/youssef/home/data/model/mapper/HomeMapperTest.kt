package com.youssef.home.data.model.mapper

import com.youssef.home.data.model.PaginationResponse
import com.youssef.home.data.model.content.AudioArticleResponse
import com.youssef.home.data.model.content.AudioBookResponse
import com.youssef.home.data.model.content.EpisodeResponse
import com.youssef.home.data.model.content.PodcastResponse
import org.junit.Assert.assertEquals
import org.junit.Test

class HomeMapperTest {

    @Test
    fun `PaginationResponse toEntity maps correctly`() {
        val paginationResponse = PaginationResponse(
            nextPage = "nextPage",
            totalPages = 5
        )

        val result = paginationResponse.toEntity()

        assertEquals("nextPage", result.nextPage)
        assertEquals(5, result.totalPages)
    }

    @Test
    fun `AudioArticleResponse toEntity maps correctly`() {
        val audioArticleResponse = AudioArticleResponse(
            article_id = "articleId",
            name = "Article Name",
            author_name = "Author Name",
            description = "Description",
            avatar_url = "Avatar URL",
            duration = 120,
            release_date = "2023-01-01",
            score = 4
        )

        val result = audioArticleResponse.toEntity()

        assertEquals("articleId", result.articleId)
        assertEquals("Article Name", result.name)
    }

    @Test
    fun `AudioBookResponse toEntity maps correctly`() {
        val audioBookResponse = AudioBookResponse(
            audiobook_id = "audiobookId",
            name = "Audiobook Name",
            author_name = "Author Name",
            description = "Description",
            avatar_url = "Avatar URL",
            duration = 300,
            language = "English",
            releaseDate = "2023-01-01",
            score = 5
        )

        val result = audioBookResponse.toEntity()

        assertEquals("audiobookId", result.audiobookId)
        assertEquals("Audiobook Name", result.name)
    }

    @Test
    fun `EpisodeResponse toEntity maps correctly`() {
        val episodeResponse = EpisodeResponse(
            episode_id = "episodeId",
            name = "Episode Name",
            season_number = 1,
            episode_type = "Episode Type",
            podcast_name = "Podcast Name",
            author_name = "Author Name",
            description = "Description",
            duration = 60,
            avatar_url = "Avatar URL",
            audio_url = "Audio URL",
            releaseDate = "2023-01-01",
            podcast_id = "podcastId",
            score = 4.5
        )

        val result = episodeResponse.toEntity()

        assertEquals("episodeId", result.episodeId)
        assertEquals("Episode Name", result.name)
    }

    @Test
    fun `PodcastResponse toEntity maps correctly`() {
        val podcastResponse = PodcastResponse(
            podcast_id = "podcastId",
            name = "Podcast Name",
            description = "Description",
            avatar_url = "Avatar URL",
            episode_count = 10,
            duration = 600,
            priority = 1,
            popularityScore = 100,
            score = 4.5
        )

        val result = podcastResponse.toEntity()

        assertEquals("podcastId", result.podcastId)
        assertEquals("Podcast Name", result.name)
    }
}