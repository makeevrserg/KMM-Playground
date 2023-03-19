package com.makeevrserg.kmmplayground.presentation.sample

import androidx.compose.runtime.Composable
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponent
import com.makeevrserg.kmmplayground.sample.Greeting

@Composable
fun SampleScreenComponent(component: RootComponent, greeting: Greeting) {
    SampleScreen(greeting = greeting, onBackPressed = component::pop)
}
