package com.makeevrserg.kmmplayground.presentation.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.pop
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterIntent
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent
import com.makeevrserg.kmmplayground.shared.BackToolBar

@Composable
fun CounterScreenComponent(component: RootComponent, viewModel: CounterViewModel) {
    val state by viewModel.stateFlow.collectAsState()
    CounterScreen(
        state = state,
        onBackPressed = component::pop,
        onIntent = viewModel::acceptCalculator
    )
}
