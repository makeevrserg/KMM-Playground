package com.makeevrserg.kmmplayground.shared

import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.ImageResource
import com.makeevrserg.kmmplayground.shared.ui.sharedPainter
@Composable
fun ImageResource.sharedPainter() = sharedPainter(this)