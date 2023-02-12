package com.makeevrserg.kmmplayground.presentation.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.pop
import com.makeevrserg.kmmplayground.presentation.calculator.store.CounterIntent
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent
import com.makeevrserg.kmmplayground.shared.BackToolBar

@Composable
fun CounterScreen(component: RootComponent, viewModel: CounterViewModel) {
    val state by viewModel.stateFlow.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackToolBar("Calculator", component.navigationController::pop)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Counter: ${state.value}")
            Button(onClick = {
                viewModel.acceptCalculator(CounterIntent.Increment)
            }, content = {
                    Text("Increment")
                })

            Button(onClick = {
                viewModel.acceptCalculator(CounterIntent.Decrement)
            }, content = {
                    Text("Decrement")
                })
        }
    }
}
