package com.makeevrserg.kmmplayground.presentation.counter.store

sealed interface CounterLabel {
    object OnIncremented : CounterLabel
    object OnDecremented : CounterLabel
}
