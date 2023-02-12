package com.makeevrserg.kmmplayground.navigation.calculator

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.makeevrserg.kmmplayground.SharedViewModel
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorIntent
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorLabel
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorState
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorStore
import dev.icerock.moko.mvvm.flow.CFlow
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cFlow
import dev.icerock.moko.mvvm.flow.cStateFlow

class CalculatorViewModel(
    storeFactory: StoreFactory
) : SharedViewModel() {
    private val store = CalculatorStore(storeFactory)
    val stateFlow: CStateFlow<CalculatorState> = store.stateFlow.cStateFlow()
    val labels: CFlow<CalculatorLabel> = store.labels.cFlow()
    fun acceptCalculator(intent: CalculatorIntent) = store.accept(intent)
}
