package com.makeevrserg.kmmplayground.dekstop

import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.makeevrserg.kmmplayground.shared_ui.SampleScreen
import javax.swing.SwingUtilities


@OptIn(ExperimentalDecomposeApi::class)
fun main() {
    val windowState = WindowState()
    val lifecycle = LifecycleRegistry()

    singleWindowApplication(
        state = windowState,
        title = "KMM-Playground",
    ) {
        LifecycleController(lifecycle, windowState)
        SampleScreen()
    }
}

private inline fun <T : Any> runOnMainThreadBlocking(crossinline block: () -> T): T {
    lateinit var result: T
    SwingUtilities.invokeAndWait { result = block() }
    return result
}