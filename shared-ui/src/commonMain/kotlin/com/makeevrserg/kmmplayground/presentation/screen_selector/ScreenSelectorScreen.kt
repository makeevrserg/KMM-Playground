package com.makeevrserg.kmmplayground.presentation.screen_selector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.push
import com.makeevrserg.kmmplayground.navigation.root.RootComponent

@Composable
fun ScreenSelectorScreen(component: RootComponent) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = component::onShowSampleClicked, content = {
            Text("Sample Screen")
        })

        Button(onClick = component::onShowRickMortyClicked, content = {
            Text("RickMorty component")
        })

        Button(onClick = component::showCalculator, content = {
            Text("Calculator")
        })
    }
}