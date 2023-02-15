package com.makeevrserg.kmmplayground.presentation.connection.store

internal sealed interface Message {
    object Connected : Message
    object Connecting : Message
    object Disconnected : Message
}
