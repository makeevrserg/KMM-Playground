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
        Button(onClick = {
            component.navigationController.push(RootScreen.SampleScreen)
        }, content = {
                Text("Sample Screen")
            })

        Button(onClick = {
            component.navigationController.push(RootScreen.RickAndMorty)
        }, content = {
                Text("RickMorty component")
            })

        Button(onClick = {
            component.navigationController.push(RootScreen.Calculator)
        }, content = {
                Text("Calculator")
            })
    }
}
