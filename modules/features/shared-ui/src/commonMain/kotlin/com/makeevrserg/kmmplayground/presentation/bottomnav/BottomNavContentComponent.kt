package com.makeevrserg.kmmplayground.presentation.bottomnav

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HideImage
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.makeevrserg.kmmplayground.components.DefaultTopAppBar
import com.makeevrserg.kmmplayground.presentation.root.component.RootComponent

@Composable
fun BottomNavContentComponent(
    rootComponent: RootComponent,
    bottomNavComponent: BottomNavComponent,
) {
    val childStack by bottomNavComponent.childStack.subscribeAsState()

    val items = listOf(
        BottomNavItem.List,
        BottomNavItem.Profile,
    )

    Scaffold(
        topBar = {
            DefaultTopAppBar(onBackPressed = rootComponent::pop)
        },
        bottomBar = {
            BottomNavigation {
                items.forEach { item ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Default.HideImage, contentDescription = null) },
                        label = {
                            Text(
                                text = "",
                            )
                        },
                        alwaysShowLabel = true,
                        selected = childStack.active.configuration == item.asChild,
                        onClick = {
                            bottomNavComponent.onChildClicked(item.asChild)
                        }
                    )
                }
            }
        }
    ) {
        Children(
            stack = childStack,
            animation = stackAnimation(slide()),
        ) {
            when (it.instance) {
                is BottomNavComponent.Configuration.List -> Text("List")
                is BottomNavComponent.Configuration.Profile -> Text("Profile")
            }
        }
    }

}