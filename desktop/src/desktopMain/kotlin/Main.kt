import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.makeevrserg.kmmplayground.core.shared.PlatformConfiguration
import com.makeevrserg.kmmplayground.dekstop.runOnUiThread
import com.makeevrserg.kmmplayground.di.ServiceLocator
import com.makeevrserg.kmmplayground.presentation.root.ComposeApplication
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponentImpl
import com.makeevrserg.kmmplayground.resources.MR
import com.makeevrserg.kmmplayground.shared.sharedPainter

@OptIn(ExperimentalDecomposeApi::class)
fun main() {
    ServiceLocator.platformConfigurationModule.initialize(PlatformConfiguration())
    val lifecycle = LifecycleRegistry()
    val root = runOnUiThread {
        val context = DefaultComponentContext(lifecycle)
        RootComponentImpl(context, ServiceLocator)
    }
    application {
        val windowState = rememberWindowState()
        LifecycleController(lifecycle, windowState)
        Window(
            state = windowState,
            title = "KMM-Playground",
            onCloseRequest = ::exitApplication,
            icon = MR.images.logo.sharedPainter()
        ) {
            ComposeApplication(root)
        }
    }
}
