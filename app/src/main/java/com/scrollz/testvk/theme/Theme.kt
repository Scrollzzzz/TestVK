package com.scrollz.testvk.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = DarkBluePrimary,
    inversePrimary = Orange,

    background = DarkGrayBackground,
    onBackground = DarkWhiteOnBackground,

    secondary = DarkGraySecondary,
    tertiary = DarkGrayTertiary,

    surface = DarkGraySurface,
    onSurface = DarkGrayOnSurface,
    onSurfaceVariant = DarkGrayOnSurfaceVariant
)

private val LightColorScheme = lightColorScheme(
    primary = LightBluePrimary,
    inversePrimary = Orange,

    background = LightWhiteBackground,
    onBackground = LightBlackOnBackground,

    secondary = LightGraySecondary,
    tertiary = LightGrayTertiary,

    surface = LightGraySurface,
    onSurface = LightBlackOnSurface,
    onSurfaceVariant = LightGrayOnSurfaceVariant
)

@Composable
fun TestVKTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            window.navigationBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
