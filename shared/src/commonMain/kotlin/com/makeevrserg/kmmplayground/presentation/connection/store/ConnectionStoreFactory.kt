package com.makeevrserg.kmmplayground.presentation.connection.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.makeevrserg.mobile.di_container.Factory
import com.makeevrserg.mobilex.ktx_core.platform.KotlinDispatchers

class ConnectionStoreFactory(
    private val dispatchers: KotlinDispatchers,
    private val storeFactory: StoreFactory
) : Factory<ConnectionStore>() {
    override fun initializer(): ConnectionStore {
        return ConnectionStoreImpl(
            dispatchers = dispatchers,
            storeFactory = storeFactory
        )
    }
    internal sealed interface Message {
        object Connected : Message
        object Connecting : Message
        object Disconnected : Message
    }

}