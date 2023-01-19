package com.makeevrserg.kmmplayground.shared_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.makeevrserg.kmmplayground.Greeting
import com.makeevrserg.kmmplayground.shared_ui.shared.sharedPainter
import com.makeevrserg.kmmplayground.shared.MR

@Composable
fun SampleScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(Greeting().greeting())
        Image(sharedPainter(MR.images.logo), "")
    }
}