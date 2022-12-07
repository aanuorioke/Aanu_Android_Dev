package com.example.bottomnavigationproject.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val NavLightColorPalette = lightColors(
    primary = NavPurple,
    primaryVariant = NavDeepPurple,
    secondary = NavTeal,
)

private val NavDarkColorPalette = darkColors(
    primary = NavLilac,
    primaryVariant = NavDeepPurple,
    secondary = NavTeal
)


@Composable
fun NavTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit){
    val themeColors = if (darkTheme) {
        NavDarkColorPalette  //use dark color palette here
    } else {
        NavLightColorPalette
    }
    MaterialTheme(
        colors = themeColors,
        typography = NavTypography,
        shapes = NavShapes,
        content = content
    )
}

@Composable
fun BottomNavigationProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}