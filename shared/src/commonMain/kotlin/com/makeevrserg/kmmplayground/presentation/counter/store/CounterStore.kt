package com.makeevrserg.kmmplayground.presentation.counter.store

import com.arkivanov.mvikotlin.core.store.Store
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Intent
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Label
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.State

interface CounterStore : Store<Intent, State, Label> {
    sealed interface Intent {
        object Increment : Intent
        object Decrement : Intent
    }

    sealed interface Label {
        object OnIncremented : Label
        object OnDecremented : Label
    }

    data class State(
        val value: Long = 0L
    )
}
