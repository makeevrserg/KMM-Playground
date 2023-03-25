package com.makeevrserg.kmmplayground.presentation.connection.store

import com.arkivanov.mvikotlin.core.store.Store
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.Intent
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.Label
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.State

interface ConnectionStore : Store<Intent, State, Label> {

    sealed interface Intent {
        object DisconnectClicked : Intent
        object ConnectClicked : Intent
        object ReconnectClicked : Intent
    }

    sealed interface State {
        object Disconnected : State
        object Connecting : State
        object Connected : State
        object Error : State
    }

    sealed interface Label
}
