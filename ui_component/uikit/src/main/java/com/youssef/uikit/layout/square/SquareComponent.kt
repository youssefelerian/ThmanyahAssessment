package com.youssef.uikit.layout.square

import androidx.compose.runtime.Composable
import com.youssef.uikit.layout.square.model.SquareUiModel
import com.youssef.uikit.ui_model.IRenderComponent

class SquareComponent(val props: SquareUiModel) : IRenderComponent {
    @Composable
    override fun Render() {
        SquareLayout(props)
    }
}