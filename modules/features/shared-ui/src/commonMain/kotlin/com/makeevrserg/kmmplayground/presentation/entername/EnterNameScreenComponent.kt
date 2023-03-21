package com.makeevrserg.kmmplayground.presentation.entername

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponent

@Composable
fun EnterNameScreenComponent(
    component: RootComponent,
    viewModel: EnterNameComponent
) {
    val state by viewModel.enterNameState.subscribeAsState()
    EnterNameScreen(
        state = state,
        onBackPressed = component::pop,
        onIntent = viewModel::acceptEnterName
    )
}
