package com.youssef.search.data.model.content


data class ContentResponse(
    val podcast_id: String?,
    val name: String?,
    val description: String?,
    val avatar_url: String?,
    val episode_count: Int?,
    val duration: Int?,
    val priority: Int?,
    val popularityScore: Int?,
    val score: Double?
)