package com.makeevrserg.kmmplayground.presentation.connection.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.State
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStoreFactory.Message
internal object ConnectionReducer : Reducer<State, Message> {
    private inline fun <reified T : State> State.reduce(
        block: (T) -> State
    ): State = (this as? T)?.let(block) ?: this

    override fun State.reduce(msg: Message): State {
        return when (msg) {
            Message.Connected -> reduce<State.Connecting> {
                State.Connected
            }

            Message.Connecting -> reduce<State.Disconnected> {
                State.Connecting
            }.reduce<State.Error> { State.Connecting }

            Message.Disconnected -> reduce<State.Connected> {
                State.Disconnected
            }.reduce<State.Connecting> { State.Disconnected }
        }
    }
}
