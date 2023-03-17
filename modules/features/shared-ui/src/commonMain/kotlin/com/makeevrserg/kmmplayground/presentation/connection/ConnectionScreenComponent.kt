package com.makeevrserg.kmmplayground.presentation.connection

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent

@Composable
fun ConnectionScreenComponent(
    component: RootComponent,
    viewModel: ConnectionComponent
) {
    val state by viewModel.state.subscribeAsState()
    ConnectionScreen(
        state = state,
        onTabBackPressed = { component.pop() },
        onIntent = viewModel::accept
    )
}
