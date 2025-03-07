package com.youssef.ui_core.theme.colors


import androidx.compose.ui.graphics.Color
import com.youssef.ui_core.theme.base.IAppColors

/**
 * Default theme Light mode colors
 */
internal object DefaultLightModeColors : IAppColors {
    // Opacity region
    override val opacityZero: Color = ColorPalette.Black
    override val opacityDark: Color = ColorPalette.white.copy(alpha = 0.5f)

    // Neutral region
    override val neutralPrimary: Color = ColorPalette.white
    override val neutralSecondary: Color = ColorPalette.Black

    // Background region
    override val backgroundPrimary: Color = ColorPalette.Alabaster
    override val backgroundOverlay: Color = ColorPalette.CodGray.copy(alpha = 0.85f)
    override val cardBackground: Color = ColorPalette.white
    override val backgroundError: Color = ColorPalette.LavenderBlush

    // Button Primary region
    override val buttonPrimaryDefault: Color = ColorPalette.Kumera
    override val buttonPrimaryDisabled: Color = ColorPalette.Kumera.copy(alpha = 0.5f)

    // Button Text region
    override val buttonTextPrimary: Color = ColorPalette.white
    override val buttonTextSecondary: Color = ColorPalette.Kumera
    override val buttonTextDisabled: Color = ColorPalette.white.copy(alpha = 0.5f)

    // Text region
    override val textPrimary: Color = ColorPalette.CodGray
    override val textSecondary: Color = ColorPalette.Nevada
    override val textDisabled: Color = ColorPalette.RollingStone
    override val textError: Color = ColorPalette.Crimson

    //Edit Text
    override val editTextBorder: Color = ColorPalette.CornflowerBlue
    override val editTextBorderFocused: Color = ColorPalette.Kumera
    override val editTextBackground: Color = ColorPalette.white
    override val editTextBorderError: Color = ColorPalette.Crimson

    override val separatorColor: Color = ColorPalette.CornflowerBlue

    override val statusSuccessBackground: Color = ColorPalette.Ottoman
    override val statusSuccessText: Color = ColorPalette.JapaneseLaurel

    override val statusErrorBackground: Color = ColorPalette.LavenderBlush
    override val statusErrorText: Color = ColorPalette.Crimson

    override val statusDefaultBackground: Color = ColorPalette.Porcelain
    override val statusDefaultText: Color = ColorPalette.Abbey


}