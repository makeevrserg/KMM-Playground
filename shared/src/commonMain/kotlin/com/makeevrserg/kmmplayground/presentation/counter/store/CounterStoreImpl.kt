package com.makeevrserg.kmmplayground.presentation.counter.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Intent
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Label
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.State

class CounterStoreImpl(
    storeFactory: StoreFactory
) : CounterStore,
    Store<Intent, State, Label> by storeFactory.create(
        name = "CounterStore",
        initialState = State(),
        executorFactory = coroutineExecutorFactory {
            onIntent<Intent> {
                dispatch(it)
            }
        },
        reducer = CounterReducer
    )
