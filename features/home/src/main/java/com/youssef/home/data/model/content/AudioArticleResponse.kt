package com.youssef.home.data.model.content


data class AudioArticleResponse(
    val article_id: String?,
    val name: String?,
    val author_name: String?,
    val description: String?,
    val avatar_url: String?,
    val duration: Int?,
    val release_date: String?,
    val score: Int?
) : ContentResponse()