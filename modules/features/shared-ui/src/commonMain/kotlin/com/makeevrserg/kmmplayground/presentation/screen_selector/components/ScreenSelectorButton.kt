package com.makeevrserg.kmmplayground.presentation.screen_selector.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.makeevrserg.kmmplayground.presentation.root.RootChild

@Composable
internal fun ScreenSelectorButton(
    text: String,
    receive: (RootChild) -> Unit,
    screen: RootChild
) {
    Button(onClick = {
        receive.invoke(screen)
    }, content = {
            Text(text)
        })
}
