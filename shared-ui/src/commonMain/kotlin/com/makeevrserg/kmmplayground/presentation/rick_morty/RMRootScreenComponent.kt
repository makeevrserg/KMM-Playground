package com.makeevrserg.kmmplayground.presentation.rick_morty

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.pop
import com.makeevrserg.kmmplayground.components.DefaultTopAppBar
import com.makeevrserg.kmmplayground.navigation.root.component.RootComponent
import com.makeevrserg.kmmplayground.presentation.rick_morty.list.RMListScreenComponent

@Composable
internal fun RMRootScreenComponent(
    component: RootComponent,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        DefaultTopAppBar(text = "RickMorty", onBackPressed = component.navigationController::pop)
        RMListScreenComponent(component)
    }
}
