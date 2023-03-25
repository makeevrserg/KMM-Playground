package com.makeevrserg.kmmplayground.presentation.screen_selector

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.makeevrserg.kmmplayground.presentation.root.RootChild
import com.makeevrserg.kmmplayground.presentation.screen_selector.components.ScreenSelectorButton

@Composable
fun ScreenSelectorScreen(
    receive: (RootChild) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenSelectorButton(
            receive = receive,
            text = "Enter Name Screen",
            screen = RootChild.EnterName
        )
        ScreenSelectorButton(
            receive = receive,
            text = "Sample Screen",
            screen = RootChild.SampleScreen
        )
        ScreenSelectorButton(
            receive = receive,
            text = "Counter",
            screen = RootChild.Counter
        )
        ScreenSelectorButton(
            receive = receive,
            text = "Connection",
            screen = RootChild.ConnectionScreen
        )
        ScreenSelectorButton(
            receive = receive,
            text = "BottomNav",
            screen = RootChild.BottomNav
        )
        ScreenSelectorButton(
            receive = receive,
            text = "Theme",
            screen = RootChild.Theme
        )
    }
}
