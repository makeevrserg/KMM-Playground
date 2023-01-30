package com.makeevrserg.kmmplayground.presentation.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.makeevrserg.kmmplayground.navigation.calculator.CalculatorComponent
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorIntent
import com.makeevrserg.kmmplayground.shared_ui.BackToolBar
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CalculatorScreen(component: CalculatorComponent) {
    val state by component.state.collectAsState()
    LaunchedEffect(Unit) {
        component.label.collectLatest {

        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackToolBar("Calculator", component::popComponent)
        Text("Counter: ${state.value}")
        Button(onClick = {
            component.onIntent(CalculatorIntent.Increment)
        }, content = {
            Text("Increment")
        })

        Button(onClick = {
            component.onIntent(CalculatorIntent.Decrement)
        }, content = {
            Text("Decrement")
        })
    }
}