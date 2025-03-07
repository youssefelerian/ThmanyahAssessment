package com.youssef.home.data.model

import com.google.gson.annotations.SerializedName

data class PaginationResponse(
    @SerializedName("next_page")
    val nextPage: String?,
    @SerializedName("total_pages")
    val totalPages: Int?
)