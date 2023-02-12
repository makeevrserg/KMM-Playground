package com.makeevrserg.kmmplayground.navigation.core

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value

class MockNavigationComponent<COMPONENT : Any, CONFIGURATION : Any> : NavigationComponent<COMPONENT, CONFIGURATION> {
    override val navigationController: StackNavigation<COMPONENT>
        get() = TODO()
    override val childStack: Value<ChildStack<COMPONENT, CONFIGURATION>>
        get() = TODO()

    override fun pop() {
        TODO("Not yet implemented")
    }

    override fun replaceAll(screen: COMPONENT) {
        TODO("Not yet implemented")
    }

    override fun replaceCurrent(screen: COMPONENT) {
        TODO("Not yet implemented")
    }

    override fun push(screen: COMPONENT) {
        TODO("Not yet implemented")
    }
}
