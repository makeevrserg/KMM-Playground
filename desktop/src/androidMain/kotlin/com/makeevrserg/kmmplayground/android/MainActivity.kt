package com.makeevrserg.kmmplayground.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.makeevrserg.kmmplayground.core.shared.PlatformConfiguration
import com.makeevrserg.kmmplayground.di.ServiceLocator
import com.makeevrserg.kmmplayground.presentation.root.ComposeApplication
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponentImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO Move into Application
        ServiceLocator.platformConfigurationModule.initialize(PlatformConfiguration(applicationContext))
        val componentContext = defaultComponentContext()
        val rootComponent = RootComponentImpl(componentContext, ServiceLocator)
        setContent {
            ComposeApplication(rootComponent)
        }
    }
}
