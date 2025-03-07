package com.youssef.uikit.line_grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.youssef.ui_core.theme.AppTheme

@Composable
fun OneRowGrid(height: Dp, content: LazyGridScope.() -> Unit) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        contentPadding = PaddingValues(AppTheme.spaces.space1Xs),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spaces.spaceL),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.spaces.spaceL)
    ) {
        content()
    }
}