package com.makeevrserg.kmmplayground.shared.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import dev.icerock.moko.resources.ImageResource
@Composable
expect fun sharedPainter(imageResource: ImageResource): Painter