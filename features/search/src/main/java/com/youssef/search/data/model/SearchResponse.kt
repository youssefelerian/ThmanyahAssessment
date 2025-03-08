package com.youssef.search.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("sections")
    val sections: List<SectionResponse>?
)