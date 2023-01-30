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
import com.makeevrserg.kmmplayground.navigation.root.RootComponent
import com.makeevrserg.kmmplayground.shared_ui.shared.sharedPainter
import com.makeevrserg.kmmplayground.shared.MR
import com.makeevrserg.kmmplayground.shared_ui.BackToolBar
import com.makeevrserg.mobilex.uitext.asComposableString

@Composable
fun SampleScreen(component: RootComponent) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackToolBar("Sample", component::pop)
        Text(Greeting().greeting())
        Text(Greeting().platform.sharedHelloWorldAsRaw().asComposableString())
        Text(Greeting().platform.sharedHelloWorldAsResource().asComposableString())
        Image(sharedPainter(MR.images.logo), "")
    }
}