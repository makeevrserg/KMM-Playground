package com.makeevrserg.kmmplayground.navigation.root

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

sealed interface RootScreen : Parcelable {
    @Parcelize
    object ConnectionScreen : RootScreen

    @Parcelize
    object ScreenSelector : RootScreen

    @Parcelize
    object RickAndMorty : RootScreen

    @Parcelize
    object SampleScreen : RootScreen

    @Parcelize
    object Counter : RootScreen
    @Parcelize
    object EnterName: RootScreen
}
