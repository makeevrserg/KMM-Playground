package com.makeevrserg.kmmplayground.navigation.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.makeevrserg.kmmplayground.di.ServiceLocator
import com.makeevrserg.kmmplayground.presentation.counter.CounterViewModel
import com.makeevrserg.kmmplayground.navigation.core.cNavigationComponent
import com.makeevrserg.kmmplayground.navigation.root.RootConfiguration
import com.makeevrserg.kmmplayground.navigation.root.RootScreen
import com.makeevrserg.kmmplayground.presentation.connection.ConnectionViewModel
import com.makeevrserg.kmmplayground.presentation.entername.EnterNameViewModel
import com.makeevrserg.mobile.di_container.getValue
import com.makeevrserg.mobilex.ktx_core.platform.KDispatchers

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {
    private val storeFactory by ServiceLocator.storeFactoryModule
    private val greeting by ServiceLocator.greetingModule
    private val localStorageRepository by ServiceLocator.localStorageRepository
    override val navigationController: StackNavigation<RootScreen> = StackNavigation()

    private val stack = childStack(
        source = navigationController,
        initialConfiguration = RootScreen.ScreenSelector,
        handleBackButton = true,
        childFactory = { config, context ->
            when (config) {
                RootScreen.ConnectionScreen -> {
                    val viewModel = context.instanceKeeper.getOrCreate {
                        ConnectionViewModel(
                            storeFactory = storeFactory,
                            dispatchers = KDispatchers
                        )
                    }
                    RootConfiguration.ConnectionScreen(
                        component = this.cNavigationComponent(),
                        viewModel = viewModel
                    )
                }

                RootScreen.Counter -> {
                    val viewModel = context.instanceKeeper.getOrCreate {
                        CounterViewModel(storeFactory)
                    }
                    RootConfiguration.Counter(
                        this,
                        viewModel
                    )
                }

                RootScreen.RickAndMorty -> RootConfiguration.RickAndMorty(this.cNavigationComponent())
                RootScreen.SampleScreen -> RootConfiguration.SampleScreen(
                    this.cNavigationComponent(),
                    greeting
                )

                RootScreen.ScreenSelector -> RootConfiguration.ScreenSelector(this.cNavigationComponent())
                RootScreen.EnterName -> {
                    val viewModel = context.instanceKeeper.getOrCreate {
                        EnterNameViewModel(storeFactory, localStorageRepository)
                    }
                    RootConfiguration.EnterName(
                        this.cNavigationComponent(),
                        viewModel
                    )
                }
            }
        }
    )

    override val childStack: Value<ChildStack<RootScreen, RootConfiguration>> = stack
    override fun pop() {
        navigationController.pop()
    }

    override fun replaceAll(screen: RootScreen) {
        navigationController.replaceAll(screen)
    }

    override fun replaceCurrent(screen: RootScreen) {
        navigationController.replaceCurrent(screen)
    }

    override fun push(screen: RootScreen) {
        navigationController.push(screen)
    }
}
