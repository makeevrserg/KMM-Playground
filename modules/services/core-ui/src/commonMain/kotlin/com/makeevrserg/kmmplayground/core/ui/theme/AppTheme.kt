package com.makeevrserg.kmmplayground.core.ui.theme

import androidx.compose.material.*
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

sealed class AppTheme(
    val materialColor: Colors,
    val typography: Typography = Typography(),
    val shapes: Shapes = Shapes(),
    val sampleColors: SampleColors
) {
    data class SampleColors(
        val blue: Color
    )
    object DefaultDarkTheme : AppTheme(
        materialColor = darkColors(),
        sampleColors = SampleColors(
            blue = Color(0xFF304C7A)
        )
    )

    object DefaultLightTheme : AppTheme(
        materialColor = lightColors(),
        sampleColors = SampleColors(
            blue = Color(0xFF1B76CA)
        )
    )
}

val LocalAppTheme: ProvidableCompositionLocal<AppTheme> = staticCompositionLocalOf {
    AppTheme.DefaultDarkTheme
}