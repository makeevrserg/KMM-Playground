package com.makeevrserg.kmmplayground.shared

import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.desc.StringDesc

@Composable
expect fun StringDesc.asComposableString(): String
