package com.youssef.search.domain.entity.content

data class ContentEntity(
    val podcastId: String,
    val name: String,
    val description: String,
    val avatarUrl: String,
    val episodeCount: String,
    val duration: String,
    val priority: String,
    val popularityScore: String,
    val score: String
)