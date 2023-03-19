package com.makeevrserg.kmmplayground.presentation.bottomnav

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.makeevrserg.kmmplayground.presentation.bottomnav.BottomNavComponent.Child
import com.makeevrserg.kmmplayground.presentation.bottomnav.BottomNavComponent.Configuration

class BottomNavComponentImpl(
    context: ComponentContext
) : BottomNavComponent, ComponentContext by context {
    override val navigationController: StackNavigation<Child> = StackNavigation()
    private val stack = childStack(
        source = navigationController,
        initialConfiguration = Child.List,
        handleBackButton = true,
        childFactory = { child, context ->
            when (child) {
                Child.List -> Configuration.List()
                Child.Profile -> Configuration.Profile()
            }
        }
    )
    override val childStack: Value<ChildStack<Child, Configuration>>
        get() = stack

    override fun onChildClicked(child: Child) {
        navigationController.replaceCurrent(child)
    }

}