package com.youssef.home.domain.entity.content

data class AudioBookEntity(
    val audiobookId: String,
    val name: String,
    val authorName: String,
    val description: String,
    val avatarUrl: String,
    val duration: Int,
    val language: String,
    val releaseDate: String,
    val score: Int
) : ContentEntity()
