package com.makeevrserg.kmmplayground.navigation.root

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.makeevrserg.kmmplayground.navigation.root.component.DefaultRootComponent

sealed interface RootScreen : Parcelable {
    @Parcelize
    object ScreenSelector : RootScreen

    @Parcelize
    object RickAndMorty : RootScreen

    @Parcelize
    object SampleScreen : RootScreen

    @Parcelize
    object Calculator : RootScreen
}