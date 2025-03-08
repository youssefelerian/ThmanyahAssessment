package com.youssef.search.domain.entity.content

data class ContentEntity(
    val podcastId: String,
    val name: String,
    val description: String,
    val avatarUrl: String,
    val episodeCount: Int,
    val duration: Int,
    val priority: Int,
    val popularityScore: Int,
    val score: Double
)