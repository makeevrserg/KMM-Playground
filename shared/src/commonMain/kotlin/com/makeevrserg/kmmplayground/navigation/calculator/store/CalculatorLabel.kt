package com.makeevrserg.kmmplayground.navigation.calculator.store

sealed interface CalculatorLabel {
    object OnIncremented : CalculatorLabel
    object OnDecremented : CalculatorLabel
}
