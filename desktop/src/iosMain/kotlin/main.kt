import androidx.compose.material.Text
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
//import com.makeevrserg.astralearner.di.ServiceLocator
//import com.makeevrserg.astralearner.navigation.RootComponent
//import com.makeevrserg.astralearner.platform.PlatformConfiguration
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
//    ServiceLocator.platformConfiguration.initialize(PlatformConfiguration())
//    val lifecycle = LifecycleRegistry()
//    val rootComponentContext = DefaultComponentContext(lifecycle)
//    val rootComponent = RootComponent(rootComponentContext, ServiceLocator)

    return ComposeUIViewController {
        Text("Hello world")
    }
}