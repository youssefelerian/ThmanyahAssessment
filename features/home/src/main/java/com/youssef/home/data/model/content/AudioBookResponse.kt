package com.youssef.home.data.model.content

data class AudioBookResponse(
    val audiobook_id: String?,
    val name: String?,
    val author_name: String?,
    val description: String?,
    val avatar_url: String?,
    val duration: Int?,
    val language: String?,
    val releaseDate: String?,
    val score: Int?
) : ContentResponse()
