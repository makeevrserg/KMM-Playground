package com.makeevrserg.kmmplayground.presentation.counter.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory

typealias CounterStore = Store<CounterIntent, CounterState, CounterLabel>

fun CounterStore(storeFactory: StoreFactory): CounterStore {
    return storeFactory.create<CounterIntent, Unit, CounterIntent, CounterState, CounterLabel>(
        name = "CalculatorStore",
        initialState = CounterState(),
        executorFactory = coroutineExecutorFactory {
            onIntent<CounterIntent> {
                dispatch(it)
            }
        },
        reducer = {
            when (it) {
                CounterIntent.Decrement -> copy(value - 1)
                CounterIntent.Increment -> copy(value + 1)
            }
        }
    )
}
