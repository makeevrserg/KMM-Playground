package com.makeevrserg.kmmplayground.shared

import androidx.compose.runtime.Composable
import com.makeevrserg.kmmplayground.shared.ui.sharedPainter
import dev.icerock.moko.resources.ImageResource
@Composable
fun ImageResource.sharedPainter() = sharedPainter(this)
