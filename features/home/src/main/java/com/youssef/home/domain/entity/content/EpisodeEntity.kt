package com.youssef.home.domain.entity.content


data class EpisodeEntity(
    val episodeId: String,
    val name: String,
    val seasonNumber: Int?,
    val episodeType: String,
    val podcastName: String,
    val authorName: String?,
    val description: String,
    val duration: Int,
    val avatarUrl: String,
    val audioUrl: String,
    val releaseDate: String,
    val podcastId: String,
    val score: Double
) : ContentEntity()