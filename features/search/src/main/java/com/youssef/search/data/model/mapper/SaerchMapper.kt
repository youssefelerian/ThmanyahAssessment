package com.youssef.search.data.model.mapper

import com.youssef.search.data.model.SearchResponse
import com.youssef.search.data.model.SectionResponse
import com.youssef.search.data.model.content.ContentResponse
import com.youssef.search.domain.entity.SearchEntity
import com.youssef.search.domain.entity.SectionEntity
import com.youssef.search.domain.entity.content.ContentEntity
import com.youssef.search.domain.entity.type.ContentType
import com.youssef.search.domain.entity.type.SectionType


fun SearchResponse.toEntity() = SearchEntity(
    sections = sections?.map { it.toEntity() } ?: emptyList(),
)

fun SectionResponse.toEntity(): SectionEntity {
    return SectionEntity(
        content = content?.map { it.toEntity() } ?: emptyList(),
        contentType = ContentType.getContentType(contentType),
        name = name.orEmpty(),
        order = order ?: 0,
        type = SectionType.getSectionType(type)
    )
}

fun ContentResponse.toEntity() = ContentEntity(
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