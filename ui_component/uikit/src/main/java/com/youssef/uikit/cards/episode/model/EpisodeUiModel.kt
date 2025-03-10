package com.youssef.uikit.cards.episode.model

import com.youssef.uikit.ui_model.UIPros

data class EpisodeUiModel(
    val isBig: Boolean,
    val title: String,
    val duration: String,
    val imageUrl: String
) : UIPros