package com.makeevrserg.kmmplayground.presentation.bottomnav

sealed interface BottomNavItem {
    val asChild: BottomNavComponent.Child

    object Profile : BottomNavItem {
        override val asChild: BottomNavComponent.Child
            get() = BottomNavComponent.Child.Profile

    }

    object List : BottomNavItem {
        override val asChild: BottomNavComponent.Child
            get() = BottomNavComponent.Child.List

    }
}