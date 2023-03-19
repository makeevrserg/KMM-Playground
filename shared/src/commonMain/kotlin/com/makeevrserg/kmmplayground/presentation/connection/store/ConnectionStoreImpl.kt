package com.makeevrserg.kmmplayground.presentation.connection.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.Intent
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.Label
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore.State
import com.makeevrserg.mobilex.ktx_core.platform.KotlinDispatchers

class ConnectionStoreImpl(
    dispatchers: KotlinDispatchers,
    storeFactory: StoreFactory
) : ConnectionStore,
    Store<Intent, State, Label> by storeFactory.create(
        name = "ConnectionStore",
        initialState = State.Disconnected,
        executorFactory = { ConnectionExecutor(dispatchers) },
        reducer = ConnectionReducer
    )
