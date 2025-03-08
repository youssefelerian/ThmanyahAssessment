package com.youssef.uikit.layout.two_row_grid

import androidx.compose.runtime.Composable
import com.youssef.uikit.layout.two_row_grid.model.TowRowGridUiModel
import com.youssef.uikit.ui_model.IRenderComponent

class TowRowGridComponent(private val props:TowRowGridUiModel) : IRenderComponent {
    @Composable
    override fun Render() {
        TwoRowGridLayout(props)
    }
}