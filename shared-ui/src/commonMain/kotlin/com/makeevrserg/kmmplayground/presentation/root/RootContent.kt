package com.makeevrserg.kmmplayground.presentation.root

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.makeevrserg.kmmplayground.presentation.sample.SampleScreen
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.makeevrserg.kmmplayground.navigation.rick_morty.DefaultRickMortyComponent
import com.makeevrserg.kmmplayground.navigation.rick_morty.RickMortyComponent
import com.makeevrserg.kmmplayground.navigation.root.RootComponent
import com.makeevrserg.kmmplayground.presentation.calculator.CalculatorScreen
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
                is RootComponent.Child.RickAndMorty -> RickMortyRootContent(child.component)
                is RootComponent.Child.ScreenSelector -> ScreenSelectorScreen(child.component)
                is RootComponent.Child.SampleScreen -> SampleScreen(child.component)
                is RootComponent.Child.Calculator -> CalculatorScreen(child.component)
            }
        }
    }
}