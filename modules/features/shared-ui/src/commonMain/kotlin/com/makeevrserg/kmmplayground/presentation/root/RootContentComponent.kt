package com.makeevrserg.kmmplayground.presentation.root

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.makeevrserg.kmmplayground.presentation.bottomnav.BottomNavContentComponent
import com.makeevrserg.kmmplayground.presentation.connection.ConnectionScreenComponent
import com.makeevrserg.kmmplayground.presentation.counter.CounterScreenComponent
import com.makeevrserg.kmmplayground.presentation.entername.EnterNameScreenComponent
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponent
import com.makeevrserg.kmmplayground.presentation.sample.SampleScreenComponent
import com.makeevrserg.kmmplayground.presentation.screen_selector.ScreenSelectorScreenComponent

@Composable
fun RootContentComponent(
    component: RootComponent,
    modifier: Modifier = Modifier
) {
    val childStack by component.childStack.subscribeAsState()
    Column(modifier = modifier) {
        Children(
            stack = childStack,
            modifier = Modifier.weight(weight = 1F),
            animation = stackAnimation(slide()),
        ) {
            when (val child = it.instance) {
                is RootConfiguration.Counter -> CounterScreenComponent(child.rootComponent, child.counterComponent)

                is RootConfiguration.SampleScreen -> SampleScreenComponent(child.rootComponent, child.greeting)

                is RootConfiguration.ScreenSelector -> ScreenSelectorScreenComponent(child.rootComponent)

                is RootConfiguration.EnterName -> EnterNameScreenComponent(
                    child.rootComponent,
                    child.enterNameComponent
                )

                is RootConfiguration.ConnectionScreen -> ConnectionScreenComponent(
                    child.rootComponent,
                    child.connectionComponent
                )

                is RootConfiguration.BottomNav -> BottomNavContentComponent(
                    rootComponent = child.rootComponent,
                    bottomNavComponent = child.bottomNavComponent
                )
            }
        }
    }
}
