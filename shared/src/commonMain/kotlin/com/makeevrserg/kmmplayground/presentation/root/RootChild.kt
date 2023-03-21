package com.makeevrserg.kmmplayground.presentation.root

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

sealed interface RootChild : Parcelable {
    @Parcelize
    object ConnectionScreen : RootChild

    @Parcelize
    object ScreenSelector : RootChild

    @Parcelize
    object SampleScreen : RootChild

    @Parcelize
    object Counter : RootChild

    @Parcelize
    object EnterName : RootChild

    @Parcelize
    object BottomNav : RootChild

    @Parcelize
    object Theme : RootChild
}
