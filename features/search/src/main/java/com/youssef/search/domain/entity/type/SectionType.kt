package com.youssef.search.domain.entity.type

enum class SectionType(val type: String) {
    SQUARE("square"),
    TWO_LINES_GRID("2_lines_grid"),
    BIG_SQUARE("big_square"),
    QUEUE("queue"),
    BIG_SQUARE_2("big square");

    companion object {
        fun getSectionType(type: String?): SectionType {
            return entries.find { it.type == type } ?: SQUARE
        }
    }
}