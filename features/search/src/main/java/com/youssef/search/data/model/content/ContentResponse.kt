package com.youssef.search.data.model.content


data class ContentResponse(
    val podcast_id: String?,
    val name: String?,
    val description: String?,
    val avatar_url: String?,
    val episode_count:String?,
    val duration:String?,
    val priority: String?,
    val popularityScore: String?,
    val score: String?
)