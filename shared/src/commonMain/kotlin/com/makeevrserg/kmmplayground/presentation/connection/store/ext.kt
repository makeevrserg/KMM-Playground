package com.makeevrserg.kmmplayground.presentation.connection.store

import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.Intent
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.State
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.Label

// In Executor

internal fun State.switch(
    onDisconnected: (State.Disconnected) -> Unit = {},
    onConnecting: (State.Connecting) -> Unit = {},
    onConnected: (State.Connected) -> Unit = {},
    onError: (State.Error) -> Unit = {},
) {
    when (this) {
        is State.Disconnected -> onDisconnected(this)
        is State.Connecting -> onConnecting(this)
        is State.Connected -> onConnected(this)
        is State.Error -> onError(this)
    }
}

// In Reducer

internal fun State.reduce(
    onDisconnected: (State.Disconnected) -> State = { it },
    onConnecting: (State.Connecting) -> State = { it },
    onConnected: (State.Connected) -> State = { it },
    onError: (State.Error) -> State = { it },
): State =
    when (this) {
        is State.Disconnected -> onDisconnected(this)
        is State.Connecting -> onConnecting(this)
        is State.Connected -> onConnected(this)
        is State.Error -> onError(this)
    }