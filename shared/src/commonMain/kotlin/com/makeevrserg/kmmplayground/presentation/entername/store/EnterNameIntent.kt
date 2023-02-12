package com.makeevrserg.kmmplayground.presentation.entername.store

sealed interface EnterNameIntent {
    class Entered(val value: String) : EnterNameIntent
    object LoadValue : EnterNameIntent
    object SaveValue : EnterNameIntent
}