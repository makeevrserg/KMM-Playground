package com.makeevrserg.kmmplayground.presentation.connection

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.makeevrserg.kmmplayground.SharedViewModel
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStoreImpl
import com.makeevrserg.mobilex.ktx_core.platform.KotlinDispatchers
import dev.icerock.moko.mvvm.flow.cStateFlow

class ConnectionViewModel(
    dispatchers: KotlinDispatchers,
    storeFactory: StoreFactory
) : SharedViewModel() {
    private val connectionStore: ConnectionStore = ConnectionStoreImpl(
        dispatchers = dispatchers,
        storeFactory = storeFactory
    )
    val state = connectionStore.stateFlow.cStateFlow()
    fun accept(intent: ConnectionStore.Intent) = connectionStore.accept(intent)
}