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
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameIntent
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameState
import com.makeevrserg.kmmplayground.shared.BackToolBar

@Composable
fun EnterNameScreen(
    component: RootComponent,
    viewModel: EnterNameViewModel
) {
    val state by viewModel.enterNameState.collectAsState()
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackToolBar("EnterName", component.navigationController::pop)
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (val state = state) {
                is EnterNameState.Loaded -> {
                    Text(
                        text = "Input new name!",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    TextField(
                        value = state.name,
                        enabled = !state.isLoading,
                        onValueChange = {
                            EnterNameIntent.Entered(it).also(viewModel::acceptEnterName)
                        }
                    )
                    Button(
                        enabled = state.isButtonEnabled,
                        onClick = {
                            EnterNameIntent.SaveValue.also(viewModel::acceptEnterName)
                        },
                        content = {
                            Text(
                                text = "Save",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    )
                }

                EnterNameState.Loading -> CircularProgressIndicator()
            }
        }
    }

}