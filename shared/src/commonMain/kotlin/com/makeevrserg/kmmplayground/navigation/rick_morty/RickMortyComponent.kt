package com.makeevrserg.kmmplayground.navigation.rick_morty

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

interface RickMortyComponent {
    val childStack: Value<ChildStack<*, Child>>

    fun popComponent()
    fun onCharacterClicked(id: Long)
    sealed interface Child : Parcelable {
        @Parcelize
        object CharacterList : Child

        @Parcelize
        class CharacterDetail(val id: Long) : Child
    }
}