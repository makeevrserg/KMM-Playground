package com.makeevrserg.kmmplayground.presentation.counter

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.makeevrserg.kmmplayground.SharedViewModel
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterIntent
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterLabel
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterState
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore
import dev.icerock.moko.mvvm.flow.CFlow
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cFlow
import dev.icerock.moko.mvvm.flow.cStateFlow

class CounterViewModel(
    storeFactory: StoreFactory
) : SharedViewModel() {
    private val store = CounterStore(storeFactory)
    val stateFlow: CStateFlow<CounterState> = store.stateFlow.cStateFlow()
    val labels: CFlow<CounterLabel> = store.labels.cFlow()
    fun acceptCalculator(intent: CounterIntent) = store.accept(intent)
}
