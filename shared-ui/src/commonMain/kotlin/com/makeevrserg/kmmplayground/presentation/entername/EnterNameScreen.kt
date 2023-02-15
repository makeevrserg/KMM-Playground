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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.makeevrserg.kmmplayground.components.DefaultTopAppBar
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameIntent
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameState

@Composable
internal fun EnterNameScreen(
    state: EnterNameState,
    onBackPressed: () -> Unit,
    onIntent: (EnterNameIntent) -> Unit
) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultTopAppBar(text = "EnterName", onBackPressed = onBackPressed)
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
                            EnterNameIntent.Entered(it).also(onIntent)
                        }
                    )
                    Button(
                        enabled = state.isButtonEnabled,
                        onClick = {
                            EnterNameIntent.SaveValue.also(onIntent)
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