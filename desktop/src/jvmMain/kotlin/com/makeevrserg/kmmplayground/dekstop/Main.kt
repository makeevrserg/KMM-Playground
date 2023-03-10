package com.makeevrserg.kmmplayground.dekstop

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.*
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.makeevrserg.kmmplayground.core.shared.PlatformConfiguration
import com.makeevrserg.kmmplayground.di.ServiceLocator
import com.makeevrserg.kmmplayground.navigation.root.component.DefaultRootComponent
import com.makeevrserg.kmmplayground.presentation.root.RootContentComponent

@OptIn(ExperimentalDecomposeApi::class)
fun main() {
    ServiceLocator.platformConfigurationModule.initialize(PlatformConfiguration())
    val lifecycle = LifecycleRegistry()
    val root = runOnUiThread {
        DefaultRootComponent(DefaultComponentContext(lifecycle))
    }
    application {
        val windowState = rememberWindowState()
        LifecycleController(lifecycle, windowState)
        Window(
            state = windowState,
            title = "KMM-Playground",
            onCloseRequest = {}
        ) {
            Surface(Modifier.fillMaxSize()) {
                MaterialTheme {
                    RootContentComponent(root)
                }
            }
        }
    }
}
