package com.youssef.home.domain.entity

import com.youssef.home.domain.entity.content.ContentEntity
import com.youssef.home.domain.entity.type.ContentType
import com.youssef.home.domain.entity.type.HomeType


data class SectionEntity(
    val content: List<ContentEntity>,
    val contentType: ContentType,
    val name: String,
    val order: Int,
    val type: HomeType
)