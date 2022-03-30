package main.statistics.compose

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.nativeCanvas
import org.jetbrains.skia.Paint
import org.jetbrains.skia.TextLine

@Composable
fun BarChart(
    start: Float,
    end: Float,
    sliceCount: Int,
    entries: List<Pair<String, Float>>,
) {
    Canvas(Modifier) {
        val slice = (end - start) / sliceCount
    }
}