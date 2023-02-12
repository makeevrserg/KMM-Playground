package com.makeevrserg.kmmplayground.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import com.arkivanov.decompose.defaultComponentContext
import com.makeevrserg.kmmplayground.navigation.root.component.DefaultRootComponent
import com.makeevrserg.kmmplayground.presentation.root.RootContent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val componentContext = defaultComponentContext()
        val rootComponent = DefaultRootComponent(componentContext)
        setContent {
            MaterialTheme(lightColors()) {
                RootContent(rootComponent)
            }
        }
    }
}