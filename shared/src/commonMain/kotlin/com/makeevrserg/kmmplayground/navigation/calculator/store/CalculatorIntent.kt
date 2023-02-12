package com.makeevrserg.kmmplayground.navigation.calculator.store

sealed interface CalculatorIntent {
    object Increment : CalculatorIntent
    object Decrement : CalculatorIntent
}
