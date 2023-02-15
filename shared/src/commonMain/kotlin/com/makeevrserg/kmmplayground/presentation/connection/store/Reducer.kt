package com.makeevrserg.kmmplayground.presentation.connection.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.State

internal object ReducerImpl : Reducer<State, Message> {
    override fun State.reduce(msg: Message): State {
        return when (msg) {
            Message.Connected -> reduce(
                onConnecting = {
                    State.Connected
                }
            )
            Message.Connecting -> reduce(
                onDisconnected = { State.Connecting },
                onError = { State.Connecting }
            )

            Message.Disconnected -> reduce(
                onConnected = { State.Disconnected },
                onConnecting = { State.Disconnected }
            )
        }
    }
}
