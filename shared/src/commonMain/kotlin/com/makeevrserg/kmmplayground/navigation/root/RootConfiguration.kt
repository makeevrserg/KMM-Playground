package com.makeevrserg.kmmplayground.navigation.root

import com.makeevrserg.kmmplayground.Greeting
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorStore
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent
import com.makeevrserg.kmmplayground.navigation.calculator.CalculatorViewModel

sealed interface RootConfiguration {
    class ScreenSelector(val component: RootComponent) : RootConfiguration

    class RickAndMorty(val component: RootComponent) : RootConfiguration

    class SampleScreen(val component: RootComponent, val greeting: Greeting) : RootConfiguration

    class Calculator(
        val component: RootComponent,
        val viewModel: CalculatorViewModel
    ) : RootConfiguration
}