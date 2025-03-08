package com.youssef.uikit.cards.audio_book.model

import com.youssef.uikit.ui_model.UIPros

data class AudioBookUiModel(
    val isBig: Boolean,
    val title: String,
    val duration: String,
    val imageUrl: String
) : UIPros