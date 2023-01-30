package com.makeevrserg.kmmplayground.presentation.root

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.makeevrserg.kmmplayground.navigation.rick_morty.RickMortyComponent
import com.makeevrserg.kmmplayground.presentation.rick_morty.list.RickMortyList
import com.makeevrserg.kmmplayground.shared_ui.BackToolBar

@Composable
fun RickMortyRootContent(component: RickMortyComponent, modifier: Modifier = Modifier) {
    val childStack by component.childStack.subscribeAsState()
    Column(modifier = modifier) {
        BackToolBar("RickMorty", component::popComponent)
        Children(
            stack = childStack,
            modifier = Modifier.weight(weight = 1F),
            animation = stackAnimation(slide()),
        ) {
            when (val child = it.instance) {
                is RickMortyComponent.Child.CharacterDetail -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("CharacterDetail")
                    }
                }
                RickMortyComponent.Child.CharacterList -> RickMortyList(component)
            }
        }
    }
}