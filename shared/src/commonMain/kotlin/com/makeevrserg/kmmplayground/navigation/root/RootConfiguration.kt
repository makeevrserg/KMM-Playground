package com.makeevrserg.kmmplayground.navigation.root

import com.makeevrserg.kmmplayground.sample.Greeting
import com.makeevrserg.kmmplayground.navigation.calculator.CalculatorViewModel
import com.makeevrserg.kmmplayground.navigation.core.CNavigationComponent
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent

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
