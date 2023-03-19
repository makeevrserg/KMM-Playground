package com.makeevrserg.kmmplayground.presentation.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.makeevrserg.kmmplayground.components.DefaultTopAppBar
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Label
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.State
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Intent

@Composable
fun CounterScreen(
    state: State,
    onBackPressed: () -> Unit,
    onIntent: (Intent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultTopAppBar(text = "Counter", onBackPressed = onBackPressed)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Counter: ${state.value}")
            Button(
                onClick = { Intent.Increment.also(onIntent) },
                content = {
                    Text("Increment")
                }
            )

            Button(
                onClick = {
                    Intent.Decrement.also(onIntent)
                },
                content = {
                    Text("Decrement")
                }
            )
        }
    }
}
