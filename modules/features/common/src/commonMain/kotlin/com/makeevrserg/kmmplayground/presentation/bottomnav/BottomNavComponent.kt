package com.makeevrserg.kmmplayground.presentation.bottomnav

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

interface BottomNavComponent {
    val navigationController: StackNavigation<Child>
    val childStack: Value<ChildStack<Child, Configuration>>
    fun onChildClicked(child: Child)
    sealed interface Configuration {
        class Profile : Configuration
        class List : Configuration
    }

    sealed interface Child : Parcelable {
        @Parcelize
        object Profile : Child

        @Parcelize
        object List : Child
    }
}
