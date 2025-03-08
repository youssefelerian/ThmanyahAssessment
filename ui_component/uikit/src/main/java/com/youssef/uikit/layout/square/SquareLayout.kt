package com.youssef.uikit.layout.square

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.youssef.ui_core.core.text.TitleLText
import com.youssef.ui_core.core.views.SpacerVertical
import com.youssef.ui_core.theme.AppTheme
import com.youssef.uikit.layout.square.model.SquareUiModel

@Composable
fun SquareLayout(model: SquareUiModel) {
    SpacerVertical(AppTheme.spaces.spaceS)
    TitleLText(model.title)
    SpacerVertical(AppTheme.spaces.spaceS)
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = Modifier
            .fillMaxWidth()
            .height(model.height),
        contentPadding = PaddingValues(AppTheme.spaces.space1Xs),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spaces.spaceL),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.spaces.spaceL)
    ) {
        items(model.componentList) { content ->
            content.Render()
        }
    }
}