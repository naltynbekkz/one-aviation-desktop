package main.statistics.compose

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VerticalBarChart(
    start: Float,
    end: Float,
    sliceCount: Int,
    color: Color,
    entries: List<BarChartEntry>,
    modifier: Modifier = Modifier,
) {
    Canvas(modifier) {
        val cellWidth = size.width / entries.size
        val cellHeight = size.height / sliceCount

        repeat(sliceCount + 1) {
            drawLine(
                color = lineColor,
                start = Offset(0f, it * cellHeight),
                end = Offset(size.width, it * cellHeight),
                strokeWidth = 2.dp.toPx()
            )
        }

        drawLine(
            color = lineColor,
            start = Offset(0f, 0f),
            end = Offset(0f, size.height),
            strokeWidth = 2.dp.toPx()
        )

        val totalValue = end - start

        entries.forEachIndexed { index, entry ->
            drawRect(
                color = color,
                topLeft = Offset(x = index * cellWidth + (cellWidth - barWidth.toPx()) / 2, y = (totalValue - entry.value) * size.height / totalValue),
                size = Size(width = barWidth.toPx(), height = entry.value * size.height / totalValue)
            )
        }
    }
}