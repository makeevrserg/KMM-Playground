package com.makeevrserg.kmmplayground.presentation.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.makeevrserg.kmmplayground.components.DefaultTopAppBar
import com.makeevrserg.kmmplayground.core.ui.theme.LocalAppTheme
import com.makeevrserg.kmmplayground.presentation.counter.store.CounterStore
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponent

@Composable
fun ThemeScreenComponent(
    rootComponent: RootComponent,
    themeComponent: ThemeComponent
) {
    Scaffold(
        topBar = {
            DefaultTopAppBar(onBackPressed = rootComponent::pop)
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = themeComponent::onDefaultLightThemeClicked,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = LocalAppTheme.current.sampleColors.blue
                ),
                content = {
                    Text("Default LightTheme")
                }
            )
            Button(
                onClick = themeComponent::onDefaultDarkThemeClicked,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = LocalAppTheme.current.sampleColors.blue
                ),
                content = {
                    Text("Default DarkTheme")
                }
            )
        }

    }
}