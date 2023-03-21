import androidx.compose.material.Text
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import platform.UIKit.UIViewController
import com.makeevrserg.kmmplayground.core.shared.PlatformConfiguration
import com.makeevrserg.kmmplayground.di.ServiceLocator
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponentImpl
import com.makeevrserg.kmmplayground.presentation.root.ComposeApplication

fun MainViewController(): UIViewController {
    ServiceLocator.platformConfigurationModule.initialize(PlatformConfiguration())
    val lifecycle = LifecycleRegistry()
    val rootComponentContext = DefaultComponentContext(lifecycle)
    val rootComponent = RootComponentImpl(rootComponentContext, ServiceLocator)

    return ComposeUIViewController {
        ComposeApplication(rootComponent)
//        Text("Hello world")
    }
}