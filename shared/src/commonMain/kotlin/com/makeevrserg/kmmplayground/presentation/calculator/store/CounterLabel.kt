package com.makeevrserg.kmmplayground.presentation.calculator.store

sealed interface CounterLabel {
    object OnIncremented : CounterLabel
    object OnDecremented : CounterLabel
}
