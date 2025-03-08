package com.youssef.uikit.ui_model

enum class UiLayoutType(val type: String) {
    SQUARE("square"),
    TWO_LINES_GRID("2_lines_grid"),
    BIG_SQUARE("big_square"),
    QUEUE("queue");

    companion object {
        fun getLayoutType(type: String?): UiLayoutType {
            return entries.find { it.type == type } ?: SQUARE
        }
    }
}