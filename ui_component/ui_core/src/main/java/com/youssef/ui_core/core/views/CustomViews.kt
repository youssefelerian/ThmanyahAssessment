package com.youssef.ui_core.core.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.youssef.ui_core.theme.AppTheme

@Composable
fun SpacerVertical(space: Dp) {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(space)
    )
}

@Composable
fun SpacerHorizontal(space: Dp) {
    Spacer(
        modifier = Modifier
            .width(space)
            .fillMaxHeight()
    )
}

@Composable
fun SeparatorVertical() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = AppTheme.colors.separatorColor)
    )
}
