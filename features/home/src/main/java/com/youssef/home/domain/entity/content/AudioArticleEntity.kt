package com.youssef.home.domain.entity.content


data class AudioArticleEntity(
    val articleId: String,
    val name: String,
    val authorName: String,
    val description: String,
    val avatarUrl: String,
    val duration: Int,
    val releaseDate: String,
    val score: Int
) : ContentEntity()