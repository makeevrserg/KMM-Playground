package com.makeevrserg.kmmplayground.presentation.connection

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStoreImpl
import com.makeevrserg.kmmplayground.util.stateValue
import com.makeevrserg.mobilex.ktx_core.platform.KotlinDispatchers

class ConnectionComponentImpl(
    componentContext: ComponentContext,
    dispatchers: KotlinDispatchers,
    storeFactory: StoreFactory
) : ConnectionComponent, ComponentContext by componentContext {
    private val connectionStore: ConnectionStore = ConnectionStoreImpl(
        dispatchers = dispatchers,
        storeFactory = storeFactory
    )
    override val state = connectionStore.stateValue()
    override fun accept(intent: ConnectionStore.Intent) = connectionStore.accept(intent)
}
