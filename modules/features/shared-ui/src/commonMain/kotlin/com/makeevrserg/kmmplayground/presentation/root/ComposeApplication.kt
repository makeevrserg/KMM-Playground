package com.makeevrserg.kmmplayground.presentation.root

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.makeevrserg.kmmplayground.core.ui.theme.AppTheme
import com.makeevrserg.kmmplayground.core.ui.theme.LocalAppTheme
import com.makeevrserg.kmmplayground.data.preferences.models.ThemeEnum
import com.makeevrserg.kmmplayground.di.ServiceLocator
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponent

@Composable
fun ComposeApplication(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier
) {
    val storageTheme: ThemeEnum by ServiceLocator.localStorageRepository.value.themeValue.stateFlow.collectAsState()
    val theme = when (storageTheme) {
        ThemeEnum.DEFAULT_DARK -> AppTheme.DefaultDarkTheme
        ThemeEnum.DEFAULT_LIGHT -> AppTheme.DefaultLightTheme
    }
    CompositionLocalProvider(
        LocalAppTheme provides theme
    ) {
        MaterialTheme(
            colors = LocalAppTheme.current.materialColor,
            typography = LocalAppTheme.current.typography,
            shapes = LocalAppTheme.current.shapes,
            content = {
                RootContentComponent(component = rootComponent, modifier = modifier)
            }
        )
    }
}