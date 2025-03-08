package com.youssef.uikit.layout.square.model

import androidx.compose.ui.unit.Dp
import com.youssef.uikit.ui_model.IRenderComponent
import com.youssef.uikit.ui_model.UIPros

data class SquareUiModel(
    val title: String,
    val height: Dp,
    val componentList: List<IRenderComponent>
) : UIPros