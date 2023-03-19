package com.makeevrserg.kmmplayground.presentation.counter.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Intent
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Label
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.State
object CounterReducer: Reducer<State, Intent> {
    override fun State.reduce(msg: Intent): State {
        return when (msg) {
            Intent.Decrement -> copy(value = value - 1)
            Intent.Increment -> copy(value = value + 1)
        }
    }
}