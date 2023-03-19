package com.makeevrserg.kmmplayground.presentation.root.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value
import com.makeevrserg.kmmplayground.presentation.root.RootConfiguration
import com.makeevrserg.kmmplayground.presentation.root.RootChild

interface RootComponent {
    val navigationController: StackNavigation<RootChild>
    val childStack: Value<ChildStack<RootChild, RootConfiguration>>

    fun push(screen: RootChild)
    fun pop()
    fun replaceCurrent(screen: RootChild)
    fun replaceAll(screen: RootChild)
}
