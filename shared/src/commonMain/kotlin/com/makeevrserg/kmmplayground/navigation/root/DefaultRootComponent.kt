package com.makeevrserg.kmmplayground.navigation.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.makeevrserg.kmmplayground.navigation.calculator.CalculatorDefaultComponent
import com.makeevrserg.kmmplayground.navigation.rick_morty.DefaultRickMortyComponent
import com.makeevrserg.kmmplayground.navigation.rick_morty.RickMortyComponent

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    private val stack = childStack(
        source = navigation,
        initialConfiguration = Config.ScreenSelector,
        childFactory = { config, context ->
            when (config) {
                Config.RickAndMorty -> RootComponent.Child.RickAndMorty(DefaultRickMortyComponent(this, context))
                Config.SampleScreen -> RootComponent.Child.SampleScreen(this)
                Config.ScreenSelector -> RootComponent.Child.ScreenSelector(this)
                Config.Calculator -> RootComponent.Child.Calculator(CalculatorDefaultComponent(this, context))
            }
        }
    )


    override val childStack: Value<ChildStack<*, RootComponent.Child>> = stack
    override fun pop() = navigation.pop()
    override fun onShowSampleClicked() = navigation.push(Config.SampleScreen)

    override fun onShowRickMortyClicked() = navigation.push(Config.RickAndMorty)
    override fun showCalculator() = navigation.push(Config.Calculator)

    private sealed interface Config : Parcelable {
        @Parcelize
        object ScreenSelector : Config

        @Parcelize
        object RickAndMorty : Config

        @Parcelize
        object SampleScreen : Config

        @Parcelize
        object Calculator : Config
    }
}