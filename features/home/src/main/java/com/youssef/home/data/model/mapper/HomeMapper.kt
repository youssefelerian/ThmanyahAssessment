package com.youssef.home.data.model.mapper

import com.youssef.home.data.model.HomeResponse
import com.youssef.home.data.model.PaginationResponse
import com.youssef.home.data.model.SectionResponse
import com.youssef.home.data.model.content.AudioArticleResponse
import com.youssef.home.data.model.content.AudioBookResponse
import com.youssef.home.data.model.content.EpisodeResponse
import com.youssef.home.data.model.content.PodcastResponse
import com.youssef.home.domain.entity.HomeEntity
import com.youssef.home.domain.entity.PaginationEntity
import com.youssef.home.domain.entity.SectionEntity
import com.youssef.home.domain.entity.content.AudioArticleEntity
import com.youssef.home.domain.entity.content.AudioBookEntity
import com.youssef.home.domain.entity.content.EpisodeEntity
import com.youssef.home.domain.entity.content.PodcastEntity
import com.youssef.home.domain.entity.type.ContentType
import com.youssef.home.domain.entity.type.SectionType


fun HomeResponse.toEntity() = HomeEntity(
    sections = sections?.map { it.toEntity() } ?: emptyList(),
    pagination = pagination.toEntity()
)

fun PaginationResponse.toEntity() = PaginationEntity(
    nextPage = nextPage.orEmpty(),
    totalPages = totalPages ?: 0
)

fun SectionResponse.toEntity(): SectionEntity {
    return SectionEntity(
        content = content?.map {
            when (it) {
                is AudioArticleResponse -> it.toEntity()
                is AudioBookResponse -> it.toEntity()
                is EpisodeResponse -> it.toEntity()
                is PodcastResponse -> it.toEntity()
            }
        } ?: emptyList(),
        contentType = ContentType.getContentType(contentType),
        name = name.orEmpty(),
        order = order ?: 0,
        type = SectionType.getSectionType(type)
    )
}

fun AudioArticleResponse.toEntity() = AudioArticleEntity(
    articleId = article_id.orEmpty(),
    name = name.orEmpty(),
    authorName = author_name.orEmpty(),
    description = description.orEmpty(),
    avatarUrl = avatar_url.orEmpty(),
    duration = duration ?: 0,
    releaseDate = release_date.orEmpty(),
    score = score ?: 0
)

fun AudioBookResponse.toEntity() = AudioBookEntity(
    audiobookId = audiobook_id.orEmpty(),
    name = name.orEmpty(),
    authorName = author_name.orEmpty(),
    description = description.orEmpty(),
    avatarUrl = avatar_url.orEmpty(),
    duration = duration ?: 0,
    language = language.orEmpty(),
    releaseDate = releaseDate.orEmpty(),
    score = score ?: 0
)

fun EpisodeResponse.toEntity() = EpisodeEntity(
    episodeId = episode_id.orEmpty(),
    name = name.orEmpty(),
    seasonNumber = season_number ?: 0,
    episodeType = episode_type.orEmpty(),
    podcastName = podcast_name.orEmpty(),
    authorName = author_name.orEmpty(),
    description = description.orEmpty(),
    duration = duration ?: 0,
    avatarUrl = avatar_url.orEmpty(),
    audioUrl = audio_url.orEmpty(),
    releaseDate = releaseDate.orEmpty(),
    podcastId = podcast_id.orEmpty(),
    score = score ?: 0.0
)

fun PodcastResponse.toEntity() = PodcastEntity(
    podcastId = podcast_id.orEmpty(),
    name = name.orEmpty(),
    description = description.orEmpty(),
    avatarUrl = avatar_url.orEmpty(),
    episodeCount = episode_count ?: 0,
    duration = duration ?: 0,
    priority = priority ?: 0,
    popularityScore = popularityScore ?: 0,
    score = score ?: 0.0
)