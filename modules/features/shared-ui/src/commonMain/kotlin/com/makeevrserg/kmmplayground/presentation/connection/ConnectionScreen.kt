package com.makeevrserg.kmmplayground.presentation.connection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.makeevrserg.kmmplayground.components.DefaultTopAppBar
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore

@Composable
fun ConnectionScreen(
    state: ConnectionStore.State,
    onTabBackPressed: () -> Unit,
    onIntent: (ConnectionStore.Intent) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            DefaultTopAppBar(onBackPressed = onTabBackPressed)
        }
    ) {
        when (state) {
            ConnectionStore.State.Connected -> {
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("You are connected!")
                    Button(onClick = { ConnectionStore.Intent.DisconnectClicked.also(onIntent) }) {
                        Text("Disconnect")
                    }
                }
            }

            ConnectionStore.State.Connecting -> {
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                    Button(onClick = { ConnectionStore.Intent.DisconnectClicked.also(onIntent) }) {
                        Text("Cancel")
                    }
                }
            }

            ConnectionStore.State.Disconnected -> {
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("You are not connected!")
                    Button(onClick = { ConnectionStore.Intent.ConnectClicked.also(onIntent) }) {
                        Text("Connect")
                    }
                }
            }

            ConnectionStore.State.Error -> {
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Error happened during connection!")
                    Button(onClick = { ConnectionStore.Intent.ReconnectClicked.also(onIntent) }) {
                        Text("Re-Connect")
                    }
                }
            }
        }
    }
}
