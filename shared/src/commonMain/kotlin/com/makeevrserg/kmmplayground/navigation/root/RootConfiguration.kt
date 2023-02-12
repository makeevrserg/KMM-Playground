package com.makeevrserg.kmmplayground.navigation.root

import com.makeevrserg.kmmplayground.sample.Greeting
import com.makeevrserg.kmmplayground.presentation.calculator.CounterViewModel
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

    class Counter(
        val component: RootComponent,
        val viewModel: CounterViewModel
    ) : RootConfiguration
}
