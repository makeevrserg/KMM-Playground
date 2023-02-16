package com.makeevrserg.kmmplayground.presentation.connection.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.Intent
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.Label
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.State
import com.makeevrserg.mobilex.ktx_core.platform.KotlinDispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class Executor(
    private val dispatchers: KotlinDispatchers
) : CoroutineExecutor<Intent, Unit, State, Message, Label>(dispatchers.Main) {
    private inline fun <reified T : State> State.switch(
        block: (T) -> Unit
    ) {
        (this as? T)?.let(block)
    }

    private var connectionJob: Job? = null
    override fun executeIntent(intent: Intent, getState: () -> State) {
        val state = getState.invoke()

        when (intent) {
            Intent.ConnectClicked -> state.switch<State.Disconnected> {
                connect()
            }

            Intent.DisconnectClicked -> {
                state.switch<State.Connected> { dispatch(Message.Disconnected) }
                state.switch<State.Connecting> {
                    connectionJob?.cancel()
                    dispatch(Message.Disconnected)
                }
            }

            Intent.ReconnectClicked -> state.switch<State.Error> { connect() }
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
