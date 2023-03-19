package com.makeevrserg.kmmplayground.navigation.root

import com.makeevrserg.kmmplayground.navigation.core.CNavigationComponent
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent
import com.makeevrserg.kmmplayground.presentation.connection.ConnectionComponentImpl
import com.makeevrserg.kmmplayground.presentation.counter.CounterComponentImpl
import com.makeevrserg.kmmplayground.presentation.entername.EnterNameComponentImpl
import com.makeevrserg.kmmplayground.sample.Greeting

sealed interface RootConfiguration {
    class ConnectionScreen(
        val component: CNavigationComponent<RootScreen, RootConfiguration>,
        val viewModel: ConnectionComponentImpl
    ) : RootConfiguration

    class ScreenSelector(
        val component: CNavigationComponent<RootScreen, RootConfiguration>
    ) : RootConfiguration

    class RickAndMorty(
        val component: CNavigationComponent<RootScreen, RootConfiguration>
    ) : RootConfiguration

    class SampleScreen(
        val component: CNavigationComponent<RootScreen, RootConfiguration>,
        val greeting: Greeting
    ) : RootConfiguration

    class Counter(
        val component: RootComponent,
        val viewModel: CounterComponentImpl
    ) : RootConfiguration

    class EnterName(
        val component: RootComponent,
        val viewModel: EnterNameComponentImpl
    ) : RootConfiguration
}
