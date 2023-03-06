package com.makeevrserg.kmmplayground.presentation.entername

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.router.stack.pop
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent

@Composable
fun EnterNameScreenComponent(
    component: RootComponent,
    viewModel: EnterNameViewModel
) {
    val state by viewModel.enterNameState.collectAsState()
    EnterNameScreen(
        state = state,
        onBackPressed = component::pop,
        onIntent = viewModel::acceptEnterName
    )
}
