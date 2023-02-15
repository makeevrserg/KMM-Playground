package com.makeevrserg.kmmplayground.presentation.counter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent

@Composable
fun CounterScreenComponent(component: RootComponent, viewModel: CounterViewModel) {
    val state by viewModel.stateFlow.collectAsState()
    CounterScreen(
        state = state,
        onBackPressed = component::pop,
        onIntent = viewModel::acceptCalculator
    )
}
