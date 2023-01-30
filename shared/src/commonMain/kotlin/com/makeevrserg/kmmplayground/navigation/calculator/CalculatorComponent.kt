package com.makeevrserg.kmmplayground.navigation.calculator

import com.arkivanov.decompose.value.Value
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorIntent
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorLabel
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorState
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface CalculatorComponent {
    val state: StateFlow<CalculatorState>
    val label: Flow<CalculatorLabel>
    fun popComponent()
    fun onIntent(intent:CalculatorIntent)
}