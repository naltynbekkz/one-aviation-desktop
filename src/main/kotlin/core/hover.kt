package core

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HoverCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    border: BorderStroke? = null,
    normalElevation: Dp = 4.dp,
    hoveredElevation: Dp = 8.dp,
    content: @Composable () -> Unit
) {

    var elevated by remember { mutableStateOf(false) }
    val elevation = remember(elevated) { if (elevated) hoveredElevation else normalElevation }
    val animatedElevation by animateDpAsState(elevation)

    Card(
        modifier = modifier
            .pointerMoveFilter(
                onEnter = { elevated = true; true },
                onExit = { elevated = false; true },
                onMove = { true }
            ),
        shape = shape,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        border = border,
        elevation = animatedElevation,
        content = content,
    )
}