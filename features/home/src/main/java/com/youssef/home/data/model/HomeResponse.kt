package com.youssef.home.data.model

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("sections")
    val sections: List<SectionResponse>?=null,
    @SerializedName("pagination")
    val pagination: PaginationResponse
)