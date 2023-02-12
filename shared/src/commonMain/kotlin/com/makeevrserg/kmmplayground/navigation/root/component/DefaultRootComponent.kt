package com.makeevrserg.kmmplayground.navigation.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.makeevrserg.kmmplayground.di.ServiceLocator
import com.makeevrserg.kmmplayground.navigation.calculator.CalculatorViewModel
import com.makeevrserg.kmmplayground.navigation.calculator.store.CalculatorStore
import com.makeevrserg.kmmplayground.navigation.core.NavigationComponent
import com.makeevrserg.kmmplayground.navigation.core.cNavigationComponent
import com.makeevrserg.kmmplayground.navigation.root.RootConfiguration
import com.makeevrserg.kmmplayground.navigation.root.RootScreen
import com.makeevrserg.mobile.di_container.getValue

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {
    private val storeFactory by ServiceLocator.storeFactoryModule
    private val greeting by ServiceLocator.greetingModule
    override val navigationController: StackNavigation<RootScreen> = StackNavigation()

    private val stack = childStack(
        source = navigationController,
        initialConfiguration = RootScreen.ScreenSelector,
        handleBackButton = true,
        childFactory = { config, context ->
            when (config) {
                RootScreen.Calculator -> {
                    val viewModel = context.instanceKeeper.getOrCreate {
                        CalculatorViewModel(storeFactory)
                    }
                    RootConfiguration.Calculator(
                        this,
                        viewModel
                    )
                }

                RootScreen.RickAndMorty -> RootConfiguration.RickAndMorty(this.cNavigationComponent())
                RootScreen.SampleScreen -> RootConfiguration.SampleScreen(this.cNavigationComponent(), greeting)
                RootScreen.ScreenSelector -> RootConfiguration.ScreenSelector(this.cNavigationComponent())
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