package com.youssef.home.domain.entity.type

enum class HomeType(val type: String) {
    SQUARE("square"),
    TWO_LINES_GRID("2_lines_grid"),
    BIG_SQUARE("big_square"),
    QUEUE("queue"),
    BIG_SQUARE_2("big square");

    companion object {
        fun getHomeType(type: String?): HomeType {
            return entries.find { it.type == type } ?: SQUARE
        }
    }
}