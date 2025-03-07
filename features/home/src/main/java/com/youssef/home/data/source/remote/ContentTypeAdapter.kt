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
        val podcastId = jsonObject.has("podcast_id")
        val episodeId = jsonObject.has("episode_id")
        val audiobookId = jsonObject.has("audiobook_id")
        val articleId = jsonObject.has("article_id")


        return when {
            podcastId -> context.deserialize(json, PodcastResponse::class.java)
            episodeId -> context.deserialize(json, EpisodeResponse::class.java)
            audiobookId -> context.deserialize(json, AudioBookResponse::class.java)
            articleId -> context.deserialize(json, AudioArticleResponse::class.java)
            else -> throw JsonParseException("Unknown content type: podcastId= $podcastId  | episodeId=$episodeId |audiobookId= $audiobookId | articleId=$articleId")
        }
    }
}