package com.makeevrserg.kmmplayground.presentation.screen_selector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.push
import com.makeevrserg.kmmplayground.presentation.root.RootChild
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponent

@Composable
fun ScreenSelectorScreen(component: RootComponent) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenSelectorButton(
            component = component,
            text = "Enter Name Screen",
            screen = RootChild.EnterName
        )
        ScreenSelectorButton(
            component = component,
            text = "Sample Screen",
            screen = RootChild.SampleScreen
        )
        ScreenSelectorButton(
            component = component,
            text = "RickMorty",
            screen = RootChild.RickAndMorty
        )
        ScreenSelectorButton(
            component = component,
            text = "Calculator",
            screen = RootChild.Counter
        )

        ScreenSelectorButton(
            component = component,
            text = "Connection",
            screen = RootChild.ConnectionScreen
        )
    }
}

@Composable
private fun ScreenSelectorButton(
    text: String,
    component: RootComponent,
    screen: RootChild
) {
    Button(onClick = {
        component.navigationController.push(screen)
    }, content = {
            Text(text)
        })
}
