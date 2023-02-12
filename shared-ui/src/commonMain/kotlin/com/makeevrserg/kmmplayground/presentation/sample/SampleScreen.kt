package com.makeevrserg.kmmplayground.presentation.sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.pop
import com.makeevrserg.kmmplayground.Greeting
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent
import com.makeevrserg.kmmplayground.resources.MR
import com.makeevrserg.kmmplayground.shared.BackToolBar
import com.makeevrserg.kmmplayground.shared.asComposableString
import com.makeevrserg.kmmplayground.shared.ui.sharedPainter

@Composable
fun SampleScreen(component: RootComponent, greeting: Greeting) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackToolBar("Sample", component.navigationController::pop)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(greeting.getHelloWorld())
            Text(greeting.platform.sharedHelloWorldAsRaw().asComposableString())
            Text(greeting.platform.sharedHelloWorldAsResource().asComposableString())
            Image(sharedPainter(MR.images.logo), "")
        }
    }
}
