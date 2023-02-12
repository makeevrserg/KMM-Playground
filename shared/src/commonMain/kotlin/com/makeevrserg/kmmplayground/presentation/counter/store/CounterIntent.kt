package com.makeevrserg.kmmplayground.presentation.counter.store

sealed interface CounterIntent {
    object Increment : CounterIntent
    object Decrement : CounterIntent
}
