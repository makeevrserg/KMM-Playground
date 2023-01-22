package com.makeevrserg.kmmplayground.presentation.root

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.value.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.makeevrserg.kmmplayground.shared_ui.SampleScreen
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun RootContent(component: RootComponent, modifier: Modifier = Modifier) {
    val childStack by component.childStack.subscribeAsState()
    val activeComponent = childStack.active.instance
    Column(modifier = modifier) {
        Children(
            stack = childStack,
            modifier = Modifier.weight(weight = 1F),
            animation = stackAnimation(slide()),
        ) {
            Text("${it.instance}")
            when (val child = it.instance) {
                is RootComponent.Child.ScreenSelectionChild -> Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = { component.onRickMortyClicked() }) {
                        Text("Open rick-morty screen")
                    }
                    Button(onClick = { component.onSampleClicked() }) {
                        Text("Open sample screen")
                    }
                }
                is RootComponent.Child.SampleScreen -> SampleScreen{
                    component.pop()
                }
                is RootComponent.Child.RickMortyChild -> Text("Not implemented")
            }
        }
    }
}