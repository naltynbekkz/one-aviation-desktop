package main.statistics.compose

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

val lineColor = Color(red = 231, green = 235, blue = 246)

@Composable
fun LineChart(
    start: Float,
    end: Float,
    sliceCount: Int,
    entries: List<LineChartEntry>,
    modifier: Modifier = Modifier,
) {
    Canvas(modifier) {
        val cellWidth = size.width / (entries.firstOrNull()?.entries?.size ?: 1)
        val cellHeight = size.height / sliceCount

        repeat(sliceCount + 1) {
            drawLine(
                color = lineColor,
                start = Offset(0f, 0f + it * cellHeight),
                end = Offset(size.width, 0f + it * cellHeight),
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

        entries.forEach {
            val points = it.entries.mapIndexed { index, fl ->
                Offset(x = index * cellWidth, y = (totalValue - fl) * size.height / totalValue)
            }
            drawPoints(
                points = points,
                pointMode = PointMode.Polygon,
                color = it.color,
                strokeWidth = 4.dp.toPx(),
            )
            drawPoints(
                points = points,
                pointMode = PointMode.Points,
                color = it.color,
                strokeWidth = 8.dp.toPx(),
                cap = StrokeCap.Round,
            )
        }
    }
}

class LineChartEntry(
    val label: String,
    val color: Color,
    val entries: List<Float>,
)