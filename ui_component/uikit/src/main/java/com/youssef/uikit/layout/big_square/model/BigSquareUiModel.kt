package com.youssef.uikit.layout.big_square.model

import com.youssef.uikit.ui_model.IRenderComponent
import com.youssef.uikit.ui_model.UIPros

data class BigSquareUiModel(
    val title: String,
    val componentList: List<IRenderComponent>
) : UIPros