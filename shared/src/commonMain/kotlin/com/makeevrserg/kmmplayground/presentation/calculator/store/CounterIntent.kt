package com.makeevrserg.kmmplayground.presentation.calculator.store

sealed interface CounterIntent {
    object Increment : CounterIntent
    object Decrement : CounterIntent
}
