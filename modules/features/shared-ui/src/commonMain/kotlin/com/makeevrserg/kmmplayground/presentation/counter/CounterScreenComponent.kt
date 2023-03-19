package com.makeevrserg.kmmplayground.presentation.counter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponent

@Composable
fun CounterScreenComponent(component: RootComponent, viewModel: CounterComponent) {
    val state by viewModel.counterState.subscribeAsState()
    CounterScreen(
        state = state,
        onBackPressed = component::pop,
        onIntent = viewModel::acceptCounterIntent
    )
}
