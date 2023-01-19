package com.makeevrserg.kmmplayground.shared_ui.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import dev.icerock.moko.resources.ImageResource
@Composable
actual fun sharedPainter(imageResource: ImageResource): Painter {
    return painterResource(imageResource.drawableResId)
}