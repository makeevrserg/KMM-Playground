package com.makeevrserg.kmmplayground.presentation.root

import com.makeevrserg.kmmplayground.presentation.bottomnav.BottomNavComponent
import com.makeevrserg.kmmplayground.presentation.connection.ConnectionComponent
import com.makeevrserg.kmmplayground.presentation.counter.CounterComponent
import com.makeevrserg.kmmplayground.presentation.entername.EnterNameComponent
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponent
import com.makeevrserg.kmmplayground.sample.Greeting

sealed interface RootConfiguration {
    class ConnectionScreen(
        val rootComponent: RootComponent,
        val connectionComponent: ConnectionComponent
    ) : RootConfiguration

    class ScreenSelector(
        val rootComponent: RootComponent
    ) : RootConfiguration

    class SampleScreen(
        val rootComponent: RootComponent,
        val greeting: Greeting
    ) : RootConfiguration

    class Counter(
        val rootComponent: RootComponent,
        val counterComponent: CounterComponent
    ) : RootConfiguration

    class EnterName(
        val rootComponent: RootComponent,
        val enterNameComponent: EnterNameComponent
    ) : RootConfiguration

    class BottomNav(
        val bottomNavComponent: BottomNavComponent,
        val rootComponent: RootComponent
    ) : RootConfiguration
}
