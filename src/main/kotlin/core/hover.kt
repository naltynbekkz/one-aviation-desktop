package core

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.hover(): Modifier = this.composed {
    var isHovered by remember { mutableStateOf(false) }
    this.onPointerEvent(PointerEventType.Enter) { isHovered = true }
        .onPointerEvent(PointerEventType.Exit) { isHovered = false }
        .background(
            color = MaterialTheme.colors.primary.copy(alpha = if (isHovered) 0.06f else 0f),
        )
}

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.hover(
    onDraw: DrawScope.() -> Unit
): Modifier = this.composed {
    var isHovered by remember { mutableStateOf(false) }
    this.onPointerEvent(PointerEventType.Enter) { isHovered = true }
        .onPointerEvent(PointerEventType.Exit) { isHovered = false }
        .drawBehind {
            if (isHovered) {
                onDraw()
            }
        }
}
