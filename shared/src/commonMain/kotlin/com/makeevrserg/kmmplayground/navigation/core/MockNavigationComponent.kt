package com.makeevrserg.kmmplayground.navigation.core

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value

class MockNavigationComponent<COMPONENT : Any, CONFIGURATION : Any>(
) : NavigationComponent<COMPONENT, CONFIGURATION> {
    override val navigationController: StackNavigation<COMPONENT>
        get() = TODO()
    override val childStack: Value<ChildStack<COMPONENT, CONFIGURATION>>
        get() = TODO()
}