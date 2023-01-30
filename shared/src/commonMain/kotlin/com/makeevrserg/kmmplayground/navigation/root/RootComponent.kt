package com.makeevrserg.kmmplayground.navigation.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.makeevrserg.kmmplayground.navigation.calculator.CalculatorComponent
import com.makeevrserg.kmmplayground.navigation.rick_morty.RickMortyComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>
    fun pop()
    fun onShowSampleClicked()
    fun onShowRickMortyClicked()
    fun showCalculator()

    sealed interface Child : Parcelable {
        @Parcelize
        class ScreenSelector(val component: RootComponent) : Child

        @Parcelize
        class RickAndMorty(val component: RickMortyComponent) : Child

        @Parcelize
        class SampleScreen(val component: RootComponent) : Child

        @Parcelize
        class Calculator(val component: CalculatorComponent) : Child
    }
}