package com.youssef.ui_core.theme.colors


import androidx.compose.ui.graphics.Color
import com.youssef.ui_core.theme.base.IAppColors

/**
 * Default theme Dark mode colors
 */
internal object DefaultDarkModeColors : IAppColors {
    // Opacity region
    override val opacityZero: Color = ColorPalette.white
    override val opacityDark: Color = ColorPalette.Black.copy(alpha = 0.5f)

    // Neutral region
    override val neutralPrimary: Color = ColorPalette.white
    override val neutralSecondary: Color = ColorPalette.white

    // Background region
    override val backgroundPrimary: Color = ColorPalette.CodGray
    override val backgroundOverlay: Color = ColorPalette.CodGray.copy(alpha = 0.85f)
    override val cardBackground: Color = ColorPalette.OuterSpace
    override val backgroundError: Color = ColorPalette.Paprika

    // Button Primary region
    override val buttonPrimaryDefault: Color = ColorPalette.MuddyWaters
    override val buttonPrimaryDisabled: Color = ColorPalette.MuddyWaters.copy(alpha = 0.5f)

    // Button Text region
    override val buttonTextPrimary: Color = ColorPalette.CodGray
    override val buttonTextSecondary: Color = ColorPalette.MuddyWaters
    override val buttonTextDisabled: Color = ColorPalette.CodGray.copy(alpha = 0.5f)

    // Text region
    override val textPrimary: Color = ColorPalette.white
    override val textSecondary: Color = ColorPalette.white
    override val textDisabled: Color = ColorPalette.SilverSand
    override val textError: Color = ColorPalette.PastelPink

    //Edit Text
    override val editTextBorder: Color = ColorPalette.Nevada
    override val editTextBorderFocused: Color = ColorPalette.MuddyWaters
    override val editTextBackground: Color = ColorPalette.OuterSpace
    override val editTextBorderError: Color = ColorPalette.PastelPink

    override val separatorColor: Color = ColorPalette.Nevada

    override val statusSuccessBackground: Color = ColorPalette.SanFelix
    override val statusSuccessText: Color = ColorPalette.BlueRomance

    override val statusErrorBackground: Color = ColorPalette.Paprika
    override val statusErrorText: Color = ColorPalette.PastelPink

    override val statusDefaultBackground: Color = ColorPalette.Porcelain
    override val statusDefaultText: Color = ColorPalette.Abbey

}