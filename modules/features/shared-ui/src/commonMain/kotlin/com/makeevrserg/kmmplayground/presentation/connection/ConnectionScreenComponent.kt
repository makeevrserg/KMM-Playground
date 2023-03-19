package com.makeevrserg.kmmplayground.presentation.connection

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent

@Composable
fun ConnectionScreenComponent(
    component: RootComponent,
    connectionComponent: ConnectionComponent
) {
    val state by connectionComponent.state.subscribeAsState()
    ConnectionScreen(
        state = state,
        onTabBackPressed = { component.pop() },
        onIntent = connectionComponent::accept
    )
}
