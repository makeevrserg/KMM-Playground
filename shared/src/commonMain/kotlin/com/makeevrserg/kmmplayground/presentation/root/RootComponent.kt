package com.makeevrserg.kmmplayground.presentation.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.makeevrserg.kmmplayground.presentation.rick_morty.RickMortyComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>

    fun onRickMortyClicked()
    fun onSampleClicked()
    fun onReplaceSampleClicked()
    fun pop()

    sealed class Child {
        class RickMortyChild(val component: RickMortyComponent) : Child()
        object ScreenSelectionChild : Child()
        object SampleScreen : Child()
    }
}