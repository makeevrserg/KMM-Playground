package com.makeevrserg.kmmplayground.navigation.calculator.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.core.store.create
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory

typealias CalculatorStore = Store<CalculatorIntent, CalculatorState, CalculatorLabel>

fun CalculatorStore(storeFactory: StoreFactory): CalculatorStore {
    return storeFactory.create<CalculatorIntent, Unit, CalculatorIntent, CalculatorState, CalculatorLabel>(
        name = "CalculatorStore",
        initialState = CalculatorState(),
        executorFactory = coroutineExecutorFactory {
            onIntent<CalculatorIntent> {
                dispatch(it)
            }
        },
        reducer = {
            when (it) {
                CalculatorIntent.Decrement -> copy(value - 1)
                CalculatorIntent.Increment -> copy(value + 1)
            }
        })
}