package com.example.todolist.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val TodoLightColorPalette = lightColors(
    primary = TodoPurple,
    primaryVariant = TodoDeepPurple,
    secondary = TodoTeal,
)

private val TodoDarkColorPalette = darkColors(
    primary = TodoLilac,
    primaryVariant = TodoDeepPurple,
    secondary = TodoTeal
)

@Composable
fun TodoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit){
    val themeColors = if (darkTheme) {
        TodoDarkColorPalette  //use dark color palette here
    } else {
        TodoLightColorPalette
    }
    MaterialTheme(
        colors = themeColors,
        typography = TodoTypography,
        shapes = TodoShapes,
        content = content
    )
}

@Composable
fun TodoListTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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