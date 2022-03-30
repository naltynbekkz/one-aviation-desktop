package main.statistics.compose

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val barWidth = 24.dp

@Composable
fun HorizontalBarChart(
    start: Float,
    end: Float,
    sliceCount: Int,
    color: Color,
    entries: List<HorizontalBarChartEntry>,
    modifier: Modifier = Modifier,
) {
    Canvas(modifier) {
        val cellWidth = size.width / sliceCount
        val cellHeight = size.height / entries.size

        repeat(sliceCount + 1) {
            drawLine(
                color = lineColor,
                start = Offset(it * cellWidth, 0f),
                end = Offset(it * cellWidth, size.height),
                strokeWidth = 2.dp.toPx()
            )
        }

        drawLine(
            color = lineColor,
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height),
            strokeWidth = 2.dp.toPx()
        )

        val totalValue = end - start

        entries.forEachIndexed { index, entry ->
            drawRect(
                color = color,
                topLeft = Offset(x = 0f, y = index * cellHeight + (cellHeight - barWidth.toPx()) / 2),
                size = Size(width = entry.value * size.width / totalValue, height = barWidth.toPx())
            )
        }
    }
}

class HorizontalBarChartEntry(
    val label: String,
    val value: Float,
)