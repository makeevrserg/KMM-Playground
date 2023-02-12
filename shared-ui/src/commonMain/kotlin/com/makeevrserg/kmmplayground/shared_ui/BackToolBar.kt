package com.makeevrserg.kmmplayground.shared_ui

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun BackToolBar(title: String = "", onBackPressed: (()->Unit)? = null) {
    TopAppBar(
        title = {
            Text(
                text = title,
            )
        },
        navigationIcon = onBackPressed?.let {
            {
                IconButton(onClick = it) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back button",
                    )
                }
            }
        },
    )
}