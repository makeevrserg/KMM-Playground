package com.makeevrserg.kmmplayground.shared.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import dev.icerock.moko.resources.ImageResource
import platform.UIKit.UIImage

@Composable
actual fun sharedPainter(imageResource: ImageResource): Painter {
    return IosBitmapPainter(imageResource.toUIImage()!!)
}
