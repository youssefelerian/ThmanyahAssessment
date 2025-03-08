package com.youssef.search.data.model

import com.google.gson.annotations.SerializedName
import com.youssef.search.data.model.content.ContentResponse

data class SectionResponse(
    @SerializedName("content")
    val content: List<ContentResponse>?,
    @SerializedName("content_type")
    val contentType: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("order")
    val order: String?,
    @SerializedName("type")
    val type: String?
)