package com.youssef.ui_components.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.youssef.ui_components.theme.base.IAppColors
import com.youssef.ui_components.theme.colors.DefaultDarkModeColors
import com.youssef.ui_components.theme.colors.DefaultLightModeColors
import com.youssef.ui_components.theme.dimens.Elevation
import com.youssef.ui_components.theme.dimens.Radius
import com.youssef.ui_components.theme.dimens.Spaces
import com.youssef.ui_components.theme.typography.getAppTypography

object AppTheme {
    val colors
        @ReadOnlyComposable
        @Composable
        get() = LocalColors.current

    val spaces
        @ReadOnlyComposable
        @Composable
        get() = LocalSpaces.current

    val radius
        @ReadOnlyComposable
        @Composable
        get() = LocalRadius.current

    val typography
        @ReadOnlyComposable
        @Composable
        get() = MaterialTheme.typography

    val isDarkMode
        @ReadOnlyComposable
        @Composable
        get() = IsLocalDarkMode.current
}

@Composable
fun AppTheme(
    isEnglish: Boolean = false,
    forceDarkTheme: Boolean? = null,
    content: @Composable () -> Unit
) {
    val isDarkMode = isNightMode(forceDarkTheme)
    val colors: IAppColors = if (isDarkMode) {
        DefaultDarkModeColors
    } else {
        DefaultLightModeColors
    }
    val colorScheme = if (isDarkMode) {
        darkColorScheme(
            primary = colors.backgroundPrimary,
            background = colors.backgroundPrimary,
            surface = colors.backgroundPrimary,
            secondary = colors.buttonPrimaryDefault,
            onPrimary = colors.backgroundPrimary,
            onSecondary = colors.buttonPrimaryDefault,
            onBackground = colors.backgroundPrimary,
            onSurface = colors.backgroundPrimary,
            tertiary = colors.textPrimary
        )
    } else {
        lightColorScheme(
            primary = colors.backgroundPrimary,
            background = colors.backgroundPrimary,
            surface = colors.backgroundPrimary,
            secondary = colors.buttonPrimaryDefault,
            onPrimary = colors.backgroundPrimary,
            onSecondary = colors.buttonPrimaryDefault,
            onBackground = colors.backgroundPrimary,
            onSurface = colors.backgroundPrimary
        )
    }

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalSpaces provides Spaces(),
        LocalRadius provides Radius(),
        LocalElevation provides Elevation(),
        LocalLayoutDirection provides if (isEnglish) LayoutDirection.Ltr else LayoutDirection.Rtl,
        IsLocalDarkMode provides isDarkMode
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = getAppTypography(isEnglish),
            content = content
        )
    }
}

private val LocalColors = staticCompositionLocalOf<IAppColors> { DefaultLightModeColors }
private val LocalSpaces = staticCompositionLocalOf { Spaces() }
private val LocalRadius = staticCompositionLocalOf { Radius() }
private val LocalElevation = staticCompositionLocalOf { Elevation() }
private val IsLocalDarkMode = staticCompositionLocalOf { false }

@Composable
private fun isNightMode(forceDarkTheme: Boolean?): Boolean {
    val isSystemInDarkTheme = isSystemInDarkTheme()
    return when {
        forceDarkTheme != null -> forceDarkTheme
        else -> isSystemInDarkTheme
    }
}