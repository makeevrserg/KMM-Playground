package com.makeevrserg.kmmplayground.presentation.entername

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.makeevrserg.kmmplayground.components.DefaultTopAppBar
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.Intent
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.State

@Composable
internal fun EnterNameScreen(
    state: State,
    onBackPressed: () -> Unit,
    onIntent: (Intent) -> Unit
) {
    Column(
        Modifier.fillMaxSize().background(MaterialTheme.colors.background),
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
                is State.Loaded -> {
                    Text(
                        text = "Input new name!",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    TextField(
                        value = state.name,
                        enabled = !state.isLoading,
                        onValueChange = {
                            Intent.Entered(it).also(onIntent)
                        }
                    )
                    Button(
                        enabled = state.isButtonEnabled,
                        onClick = {
                            Intent.SaveValue.also(onIntent)
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

                State.Loading -> CircularProgressIndicator()
            }
        }
    }
}
