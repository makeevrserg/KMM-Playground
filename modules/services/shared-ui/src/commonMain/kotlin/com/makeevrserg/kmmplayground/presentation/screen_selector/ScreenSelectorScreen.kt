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
import com.makeevrserg.kmmplayground.navigation.root.RootScreen
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent

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
            screen = RootScreen.EnterName
        )
        ScreenSelectorButton(
            component = component,
            text = "Sample Screen",
            screen = RootScreen.SampleScreen
        )
        ScreenSelectorButton(
            component = component,
            text = "RickMorty",
            screen = RootScreen.RickAndMorty
        )
        ScreenSelectorButton(
            component = component,
            text = "Calculator",
            screen = RootScreen.Counter
        )

        ScreenSelectorButton(
            component = component,
            text = "Connection",
            screen = RootScreen.ConnectionScreen
        )
    }
}

@Composable
private fun ScreenSelectorButton(
    text: String,
    component: RootComponent,
    screen: RootScreen
) {
    Button(onClick = {
        component.navigationController.push(screen)
    }, content = {
            Text(text)
        })
}
