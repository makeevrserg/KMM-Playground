package com.makeevrserg.kmmplayground.presentation.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.makeevrserg.kmmplayground.di.ServiceLocator
import com.makeevrserg.kmmplayground.presentation.bottomnav.BottomNavComponentImpl
import com.makeevrserg.kmmplayground.presentation.connection.ConnectionComponentImpl
import com.makeevrserg.kmmplayground.presentation.counter.CounterComponentImpl
import com.makeevrserg.kmmplayground.presentation.entername.EnterNameComponentImpl
import com.makeevrserg.kmmplayground.presentation.root.RootChild
import com.makeevrserg.kmmplayground.presentation.root.RootConfiguration
import com.makeevrserg.mobilex.ktx_core.platform.KDispatchers

class RootComponentImpl(
    componentContext: ComponentContext,
    serviceLocator: ServiceLocator
) : RootComponent, ComponentContext by componentContext {
    override val navigationController: StackNavigation<RootChild> = StackNavigation()

    private val stack = childStack(
        source = navigationController,
        initialConfiguration = RootChild.ScreenSelector,
        handleBackButton = true,
        childFactory = { config, context ->
            when (config) {
                RootChild.ConnectionScreen -> {
                    val viewModel = ConnectionComponentImpl(
                        componentContext = context,
                        storeFactory = serviceLocator.storeFactoryModule.value,
                        dispatchers = KDispatchers
                    )
                    RootConfiguration.ConnectionScreen(
                        rootComponent = this,
                        connectionComponent = viewModel
                    )
                }

                RootChild.Counter -> {
                    RootConfiguration.Counter(
                        rootComponent = this,
                        counterComponent = CounterComponentImpl(
                            context = context,
                            storeFactory = serviceLocator.storeFactoryModule.value
                        )
                    )
                }

                RootChild.SampleScreen -> RootConfiguration.SampleScreen(
                    this,
                    serviceLocator.greetingModule.value
                )

                RootChild.ScreenSelector -> RootConfiguration.ScreenSelector(this)

                RootChild.EnterName -> {
                    RootConfiguration.EnterName(
                        this,
                        EnterNameComponentImpl(
                            context = context,
                            storeFactory = serviceLocator.storeFactoryModule.value,
                            localPreferencesRepository = serviceLocator.localStorageRepository.value
                        )
                    )
                }

                RootChild.BottomNav -> {
                    RootConfiguration.BottomNav(
                        rootComponent = this,
                        bottomNavComponent = BottomNavComponentImpl(
                            context = context
                        )
                    )
                }
            }
        }
    )

    override val childStack: Value<ChildStack<RootChild, RootConfiguration>> = stack
    override fun pop() {
        navigationController.pop()
    }

    override fun replaceAll(screen: RootChild) {
        navigationController.replaceAll(screen)
    }

    override fun replaceCurrent(screen: RootChild) {
        navigationController.replaceCurrent(screen)
    }

    override fun push(screen: RootChild) {
        navigationController.push(screen)
    }
}
