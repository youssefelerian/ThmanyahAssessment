package com.youssef.home.data.source.remote

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.youssef.home.data.model.content.AudioArticleResponse
import com.youssef.home.data.model.content.AudioBookResponse
import com.youssef.home.data.model.content.ContentResponse
import com.youssef.home.data.model.content.EpisodeResponse
import com.youssef.home.data.model.content.PodcastResponse
import java.lang.reflect.Type

class ContentTypeAdapter : JsonDeserializer<ContentResponse> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ContentResponse {
        val jsonObject = json.asJsonObject
        val contentType = jsonObject.get("content_type").asString

        return when (contentType) {
            "podcast" -> context.deserialize(json, PodcastResponse::class.java)
            "episode" -> context.deserialize(json, EpisodeResponse::class.java)
            "audio_book" -> context.deserialize(json, AudioBookResponse::class.java)
            "audio_article" -> context.deserialize(json, AudioArticleResponse::class.java)
            else -> throw JsonParseException("Unknown content type: $contentType")
        }
    }
}