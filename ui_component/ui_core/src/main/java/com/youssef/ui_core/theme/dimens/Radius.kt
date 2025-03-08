package com.youssef.ui_core.theme.dimens

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp

@Immutable
data class Radius(
    val radiusXS: RoundedCornerShape = RoundedCornerShape(4.dp),
    val radiusS: RoundedCornerShape = RoundedCornerShape(8.dp),
    val radiusL: RoundedCornerShape = RoundedCornerShape(12.dp),
    val radiusXl: RoundedCornerShape = RoundedCornerShape(16.dp),
    val radius2Xl: RoundedCornerShape = RoundedCornerShape(20.dp),
    val radius3Xl: RoundedCornerShape = RoundedCornerShape(100.dp)
)
