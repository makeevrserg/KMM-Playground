package com.makeevrserg.kmmplayground.presentation.counter

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Intent
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Label
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStoreFactory
import com.makeevrserg.kmmplayground.util.stateValue
import dev.icerock.moko.mvvm.flow.CFlow
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cFlow
import dev.icerock.moko.mvvm.flow.cStateFlow

class CounterComponentImpl(
    context: ComponentContext,
    storeFactory: StoreFactory
) : CounterComponent, ComponentContext by context {
    private val store = CounterStoreFactory(storeFactory).value
    override val counterStateFlow: CStateFlow<CounterStore.State> = store.stateFlow.cStateFlow()
    override val counterState = store.stateValue()
    override val counterLabels: CFlow<Label> = store.labels.cFlow()
    override fun acceptCounterIntent(intent: Intent) = store.accept(intent)
}
