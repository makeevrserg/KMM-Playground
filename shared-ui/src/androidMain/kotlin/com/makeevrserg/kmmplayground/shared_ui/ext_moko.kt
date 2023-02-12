package com.makeevrserg.kmmplayground.shared_ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import dev.icerock.moko.resources.desc.StringDesc

@Composable
actual fun StringDesc.asComposableString(): String {
    val context = LocalContext.current
    return this.toString(context)
}