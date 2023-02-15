package com.makeevrserg.kmmplayground.presentation.connection

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent

@Composable
fun ConnectionScreenComponent(
    component: RootComponent,
    viewModel: ConnectionViewModel
) {
    val state by viewModel.state.collectAsState()
    ConnectionScreen(
        state = state,
        onTabBackPressed = { component.pop() },
        onIntent = viewModel::accept
    )
}