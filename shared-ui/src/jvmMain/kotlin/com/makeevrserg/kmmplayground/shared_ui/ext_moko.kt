package com.makeevrserg.kmmplayground.shared_ui

import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.desc.StringDesc

@Composable
actual fun StringDesc.asComposableString(): String {
    return this.localized()
}