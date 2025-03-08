package com.youssef.uikit.layout.big_square

import androidx.compose.runtime.Composable
import com.youssef.uikit.layout.big_square.model.BigSquareUiModel
import com.youssef.uikit.ui_model.IRenderComponent

class BigSquareComponent(private val props: BigSquareUiModel) : IRenderComponent {
    @Composable
    override fun Render() {
        BigSquareLayout(props)
    }
}