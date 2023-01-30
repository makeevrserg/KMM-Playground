package com.makeevrserg.kmmplayground.navigation.calculator

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorIntent
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorLabel
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorState
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorStore
import com.makeevrserg.kmmplayground.navigation.root.RootComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

class CalculatorDefaultComponent(
    private val rootComponent: RootComponent,
    componentContext: ComponentContext
) : CalculatorComponent, ComponentContext by componentContext {
    private val storeFactory = DefaultStoreFactory()
    private val store = instanceKeeper.getStore {
        CalculatorStore(storeFactory)
    }

    override fun popComponent() = rootComponent.pop()
    @OptIn(ExperimentalCoroutinesApi::class)
    override val state: StateFlow<CalculatorState>
        get() = store.stateFlow
    override val label: Flow<CalculatorLabel>
        get() = store.labels

    override fun onIntent(intent: CalculatorIntent) {
        store.accept(intent)
    }
}