package com.makeevrserg.kmmplayground.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.makeevrserg.kmmplayground.resources.MR
import com.makeevrserg.kmmplayground.shared.ui.sharedPainter

@Composable
fun DefaultTopAppBar(
    modifier: Modifier = Modifier,
    text: String = "",
    onBackPressed: (() -> Unit)? = null,
    content: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
    ) {
        onBackPressed?.let {
            IconButton(onClick = it) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = null,
                )
            }
        }
        Image(
            painter = sharedPainter(MR.images.logo),
            contentDescription = "",
            Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        content.invoke(this)
    }
}