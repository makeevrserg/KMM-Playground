package com.makeevrserg.kmmplayground.presentation.connection

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStoreImpl
import com.makeevrserg.kmmplayground.util.stateValue
import com.makeevrserg.mobilex.ktx_core.platform.KotlinDispatchers

class ConnectionComponent(
    componentContext: ComponentContext,
    dispatchers: KotlinDispatchers,
    storeFactory: StoreFactory
) : ComponentContext by componentContext {
    private val connectionStore: ConnectionStore = ConnectionStoreImpl(
        dispatchers = dispatchers,
        storeFactory = storeFactory
    )
    val state = connectionStore.stateValue()
    fun accept(intent: ConnectionStore.Intent) = connectionStore.accept(intent)
}
