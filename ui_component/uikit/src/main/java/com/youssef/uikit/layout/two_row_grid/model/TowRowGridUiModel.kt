package com.youssef.uikit.layout.two_row_grid.model

import androidx.compose.ui.unit.Dp
import com.youssef.uikit.ui_model.IRenderComponent
import com.youssef.uikit.ui_model.UIPros

data class TowRowGridUiModel(
    val title: String,
    val height: Dp,
    val componentList: List<IRenderComponent>
) : UIPros