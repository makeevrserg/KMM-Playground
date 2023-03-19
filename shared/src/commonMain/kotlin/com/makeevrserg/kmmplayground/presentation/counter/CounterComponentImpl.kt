package com.makeevrserg.kmmplayground.presentation.counter

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.makeevrserg.kmmplayground.SharedViewModel
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Intent
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Label
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStoreFactory
import com.makeevrserg.kmmplayground.util.stateValue
import dev.icerock.moko.mvvm.flow.CFlow
import dev.icerock.moko.mvvm.flow.cFlow

class CounterComponentImpl(
    context: ComponentContext,
    storeFactory: StoreFactory
) : CounterComponent, ComponentContext by context {
    private val store = CounterStoreFactory(storeFactory).value
    override val counterState = store.stateValue()
    override val counterLabels: CFlow<Label> = store.labels.cFlow()
    override fun acceptCounterIntent(intent: Intent) = store.accept(intent)
}
