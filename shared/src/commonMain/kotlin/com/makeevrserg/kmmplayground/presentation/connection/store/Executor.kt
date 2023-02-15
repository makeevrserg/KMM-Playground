package com.makeevrserg.kmmplayground.presentation.connection.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor

import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.Intent
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.State
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.Label
import com.makeevrserg.mobilex.ktx_core.platform.KotlinDispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class Executor(
    private val dispatchers: KotlinDispatchers
) : CoroutineExecutor<Intent, Unit, State, Message, Label>(dispatchers.Main) {
    private var connectionJob: Job? = null
    override fun executeIntent(intent: Intent, getState: () -> State) {
        val state = getState.invoke()
        when (intent) {
            Intent.ConnectClicked -> state.switch(
                onDisconnected = { connect() }
            )

            Intent.DisconnectClicked -> state.switch(
                onConnected = { dispatch(Message.Disconnected) },
                onConnecting = {
                    connectionJob?.cancel()
                    dispatch(Message.Disconnected)
                }
            )

            Intent.ReconnectClicked -> state.switch(
                onError = { connect() }
            )
        }
    }

    private fun connect() {
        dispatch(Message.Connecting)
        connectionJob = scope.launch(dispatchers.IO) {
            delay(2000)
            withContext(dispatchers.Main) {
                dispatch(Message.Connected)
            }
        }
    }
}