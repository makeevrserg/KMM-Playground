package com.makeevrserg.kmmplayground.presentation.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    private val stack = childStack(
        source = navigation,
        initialStack = { listOf(Config.ScreenSelection) },
        childFactory = { configuration, context ->
            when (configuration) {
                is Config.Characters -> TODO()
                is Config.ScreenSelection -> RootComponent.Child.ScreenSelectionChild
                is Config.Sample -> RootComponent.Child.SampleScreen
            }
        }

    )

    override val childStack: Value<ChildStack<*, RootComponent.Child>> = stack

    override fun onRickMortyClicked() {
        navigation.bringToFront(Config.Characters)
    }

    override fun onSampleClicked() {
        navigation.bringToFront(Config.Sample)
    }

    override fun onReplaceSampleClicked() {
        navigation.replaceCurrent(Config.Sample)
    }

    override fun pop() {
        navigation.pop()
    }

    private sealed class Config : Parcelable {
        @Parcelize
        object Characters : Config()

        @Parcelize
        object ScreenSelection : Config()

        @Parcelize
        object Sample : Config()
    }
}