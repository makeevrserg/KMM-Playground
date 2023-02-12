package com.makeevrserg.kmmplayground.presentation.entername.store

sealed interface EnterNameMessage {
    class Entered(val value: String) : EnterNameMessage
    class FirstLoaded(val value: String) : EnterNameMessage
    class SetLoading(val state: Boolean) : EnterNameMessage
}