package com.makeevrserg.kmmplayground.navigation.root

import com.makeevrserg.kmmplayground.Greeting
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorStore
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent
import com.makeevrserg.kmmplayground.navigation.calculator.CalculatorViewModel
import com.makeevrserg.kmmplayground.navigation.core.CNavigationComponent

sealed interface RootConfiguration {
    class ScreenSelector(val component: CNavigationComponent<RootScreen, RootConfiguration>) :
        RootConfiguration

    class RickAndMorty(val component: CNavigationComponent<RootScreen, RootConfiguration>) :
        RootConfiguration

    class SampleScreen(
        val component: CNavigationComponent<RootScreen, RootConfiguration>,
        val greeting: Greeting
    ) : RootConfiguration

    class Calculator(
        val component: RootComponent,
        val viewModel: CalculatorViewModel
    ) : RootConfiguration
}