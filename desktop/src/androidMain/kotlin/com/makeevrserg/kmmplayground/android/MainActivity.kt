package com.makeevrserg.kmmplayground.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import com.arkivanov.decompose.defaultComponentContext
import com.makeevrserg.kmmplayground.core.shared.PlatformConfiguration
import com.makeevrserg.kmmplayground.di.ServiceLocator
import com.makeevrserg.kmmplayground.navigation.root.component.DefaultRootComponent
import com.makeevrserg.kmmplayground.presentation.root.RootContentComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO Move into Application
        ServiceLocator.platformConfigurationModule.initialize(PlatformConfiguration(applicationContext))
        val componentContext = defaultComponentContext()
        val rootComponent = DefaultRootComponent(componentContext)
        setContent {
            MaterialTheme(lightColors()) {
                RootContentComponent(rootComponent)
            }
        }
    }
}
