package com.makeevrserg.kmmplayground.presentation.connection

import com.arkivanov.decompose.value.Value
import com.makeevrserg.kmmplayground.presentation.connection.store.ConnectionStore

interface ConnectionComponent {
    val state: Value<ConnectionStore.State>
    fun accept(intent: ConnectionStore.Intent)
}
