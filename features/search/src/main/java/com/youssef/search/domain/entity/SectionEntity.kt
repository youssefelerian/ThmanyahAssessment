package com.youssef.search.domain.entity


import com.youssef.search.domain.entity.content.ContentEntity
import com.youssef.search.domain.entity.type.ContentType
import com.youssef.search.domain.entity.type.SectionType

data class SectionEntity(
    val content: List<ContentEntity>,
    val contentType: ContentType,
    val name: String,
    val order: String,
    val type: SectionType
)