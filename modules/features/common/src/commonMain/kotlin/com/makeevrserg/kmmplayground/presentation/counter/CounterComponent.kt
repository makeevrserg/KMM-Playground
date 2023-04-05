package com.makeevrserg.kmmplayground.presentation.counter

import com.arkivanov.decompose.value.Value
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Intent
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore.Label
import dev.icerock.moko.mvvm.flow.CFlow
import dev.icerock.moko.mvvm.flow.CStateFlow

interface CounterComponent {
    val counterState: Value<CounterStore.State>
    val counterStateFlow: CStateFlow<CounterStore.State>
    val counterLabels: CFlow<Label>
    fun acceptCounterIntent(intent: Intent)
}
