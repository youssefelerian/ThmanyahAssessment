package com.youssef.home.domain.entity.type

enum class ContentType(val type: String) {
    PODCAST("podcast"),
    EPISODE("episode"),
    AUDIO_BOOK("audio_book"),
    AUDIO_ARTICLE("audio_article");

    companion object {
        fun getContentType(type: String?): ContentType {
            return entries.find { it.type == type } ?: PODCAST
        }
    }
}