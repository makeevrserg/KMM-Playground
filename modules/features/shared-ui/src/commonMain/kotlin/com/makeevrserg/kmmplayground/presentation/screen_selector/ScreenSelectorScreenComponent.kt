package com.makeevrserg.kmmplayground.presentation.screen_selector

import androidx.compose.runtime.Composable
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponent

@Composable
fun ScreenSelectorScreenComponent(
    component: RootComponent
) {
    ScreenSelectorScreen(
        component::push
    )
}
