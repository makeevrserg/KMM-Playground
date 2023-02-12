package com.makeevrserg.kmmplayground.presentation.root

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.makeevrserg.kmmplayground.navigation.root.RootConfiguration
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent
import com.makeevrserg.kmmplayground.presentation.counter.CounterScreen
import com.makeevrserg.kmmplayground.presentation.entername.EnterNameScreen
import com.makeevrserg.kmmplayground.presentation.sample.SampleScreen
import com.makeevrserg.kmmplayground.presentation.screen_selector.ScreenSelectorScreen

@Composable
fun RootContent(component: RootComponent, modifier: Modifier = Modifier) {
    val childStack by component.childStack.subscribeAsState()
    Column(modifier = modifier) {
        Children(
            stack = childStack,
            modifier = Modifier.weight(weight = 1F),
            animation = stackAnimation(slide()),
        ) {
            when (val child = it.instance) {
                is RootConfiguration.Counter -> CounterScreen(child.component, child.viewModel)
                is RootConfiguration.RickAndMorty -> RickMortyRootContent(child.component)
                is RootConfiguration.SampleScreen -> SampleScreen(child.component, child.greeting)
                is RootConfiguration.ScreenSelector -> ScreenSelectorScreen(child.component)
                is RootConfiguration.EnterName -> EnterNameScreen(child.component, child.viewModel)
            }
        }
    }
}
