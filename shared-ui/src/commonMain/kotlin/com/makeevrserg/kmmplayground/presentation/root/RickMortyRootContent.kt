package com.makeevrserg.kmmplayground.presentation.root

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.arkivanov.decompose.router.stack.pop
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent
import com.makeevrserg.kmmplayground.presentation.rick_morty.list.RickMortyList
import com.makeevrserg.kmmplayground.shared_ui.BackToolBar

@Composable
fun RickMortyRootContent(component: RootComponent, modifier: Modifier = Modifier) {
    val childStack by component.childStack.subscribeAsState()
    Column(modifier = modifier) {
        BackToolBar("RickMorty", component.navigationController::pop)
        RickMortyList(component)
    }
}