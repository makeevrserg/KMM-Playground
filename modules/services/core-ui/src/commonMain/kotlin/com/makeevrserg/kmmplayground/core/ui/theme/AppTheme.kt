package com.makeevrserg.kmmplayground.core.ui.theme

import androidx.compose.material.*

sealed class AppTheme(
    val materialColor: Colors,
    val typography: Typography = Typography(),
    val shapes: Shapes = Shapes()
) {
    object DefaultDarkTheme : AppTheme(
        materialColor = darkColors()
    )
    object DefaultLightTheme : AppTheme(
        materialColor = lightColors()
    )
}