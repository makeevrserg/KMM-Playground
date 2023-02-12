package com.makeevrserg.kmmplayground.navigation.core

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value

interface NavigationComponent<SCREEN : Any, CONFIGURATION : Any> {
    val navigationController: StackNavigation<SCREEN>
    val childStack: Value<ChildStack<SCREEN, CONFIGURATION>>

    fun push(screen: SCREEN)
    fun pop()
    fun replaceCurrent(screen: SCREEN)
    fun replaceAll(screen: SCREEN)
}
