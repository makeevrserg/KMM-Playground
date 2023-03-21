import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.makeevrserg.kmmplayground.core.shared.PlatformConfiguration
import com.makeevrserg.kmmplayground.core.ui.theme.AppTheme
import com.makeevrserg.kmmplayground.data.preferences.models.ThemeEnum
import com.makeevrserg.kmmplayground.dekstop.runOnUiThread
import com.makeevrserg.kmmplayground.di.ServiceLocator
import com.makeevrserg.kmmplayground.presentation.root.RootContentComponent
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponentImpl
import com.makeevrserg.kmmplayground.resources.MR
import com.makeevrserg.kmmplayground.shared.ui.sharedPainter

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
            val storageTheme: ThemeEnum by ServiceLocator.localStorageRepository.value.themeValue.stateFlow.collectAsState()
            val theme = when (storageTheme) {
                ThemeEnum.DEFAULT_DARK -> AppTheme.DefaultDarkTheme
                ThemeEnum.DEFAULT_LIGHT -> AppTheme.DefaultLightTheme
            }
            MaterialTheme(
                colors = theme.materialColor,
                typography = theme.typography,
                shapes = theme.shapes,
                content = {
                    RootContentComponent(root)
                }
            )
        }
    }
}
