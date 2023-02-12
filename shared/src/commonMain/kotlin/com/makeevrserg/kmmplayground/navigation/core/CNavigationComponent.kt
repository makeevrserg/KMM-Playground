package com.makeevrserg.kmmplayground.navigation.core

class CNavigationComponent<SCREEN : Any, CONFIGURATION : Any>(
    val component: NavigationComponent<SCREEN, CONFIGURATION>
) : NavigationComponent<SCREEN, CONFIGURATION> by component

inline fun <SCREEN : Any, CONFIGURATION : Any> NavigationComponent<SCREEN, CONFIGURATION>.cNavigationComponent(): CNavigationComponent<SCREEN, CONFIGURATION> {
    return CNavigationComponent(this)
}