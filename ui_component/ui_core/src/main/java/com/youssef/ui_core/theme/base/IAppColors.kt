package com.youssef.ui_core.theme.base

import androidx.compose.ui.graphics.Color

interface IAppColors {
    // Neutral region
    val neutralPrimary: Color
    val neutralSecondary: Color

    // Background region
    val backgroundPrimary: Color
    val backgroundOverlay: Color
    val cardBackground: Color
    val backgroundError: Color

    // Button Primary region
    val buttonPrimaryDefault: Color
    val buttonPrimaryDisabled: Color

    // Button Text region
    val buttonTextPrimary: Color
    val buttonTextSecondary: Color
    val buttonTextDisabled: Color

    // Text region
    val textPrimary: Color
    val textSecondary: Color
    val textDisabled: Color
    val textError: Color

    // Opacity region
    val opacityZero: Color
    val opacityDark: Color

    //Edit Text
    val editTextBorder: Color
    val editTextBorderFocused: Color
    val editTextBackground: Color
    val editTextBorderError: Color

    val separatorColor: Color

    val statusSuccessBackground: Color
    val statusSuccessText: Color

    val statusErrorBackground: Color
    val statusErrorText: Color

    val statusDefaultBackground: Color
    val statusDefaultText: Color

}