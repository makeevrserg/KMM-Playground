package com.makeevrserg.kmmplayground.presentation.entername

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.arkivanov.decompose.router.stack.pop
import com.makeevrserg.kmmplayground.components.DefaultTopAppBar
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameIntent
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameState

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