package com.makeevrserg.kmmplayground.navigation.rick_morty

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.makeevrserg.kmmplayground.navigation.root.RootComponent

class DefaultRickMortyComponent(
    private val rootComponent: RootComponent,
    componentContext: ComponentContext
) : RickMortyComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()
    private val stack = childStack(
        source = navigation,
        initialConfiguration = Config.List,
        childFactory = { config, context ->
            when (config) {
                is Config.Detail -> RickMortyComponent.Child.CharacterDetail(config.id)
                Config.List -> RickMortyComponent.Child.CharacterList
            }
        }
    )
    override val childStack: Value<ChildStack<*, RickMortyComponent.Child>> = stack
    override fun onCharacterClicked(id: Long) = navigation.push(Config.Detail(id))
    override fun popComponent() = rootComponent.pop()
    private sealed interface Config : Parcelable {
        @Parcelize
        object List : Config

        @Parcelize
        class Detail(val id: Long) : Config
    }
}