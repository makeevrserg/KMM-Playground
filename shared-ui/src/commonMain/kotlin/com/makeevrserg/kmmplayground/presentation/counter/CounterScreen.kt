package com.makeevrserg.kmmplayground.presentation.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.pop
import com.makeevrserg.kmmplayground.components.DefaultTopAppBar
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterIntent
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterState
import com.makeevrserg.kmmplayground.shared.BackToolBar

@Composable
fun CounterScreen(
    state: CounterState,
    onBackPressed: () -> Unit,
    onIntent: (CounterIntent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultTopAppBar(text = "Calculator", onBackPressed = onBackPressed)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Counter: ${state.value}")
            Button(
                onClick = { CounterIntent.Increment.also(onIntent) },
                content = {
                    Text("Increment")
                }
            )

            Button(
                onClick = {
                    CounterIntent.Decrement.also(onIntent)
                }, content = {
                    Text("Decrement")
                }
            )
        }
    }
}