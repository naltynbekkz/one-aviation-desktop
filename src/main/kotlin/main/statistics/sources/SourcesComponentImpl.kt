package main.statistics.sources

import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.ComponentContext
import main.statistics.compose.LineChartEntry

class SourcesComponentImpl(
    componentContext: ComponentContext,
) : SourcesComponent, ComponentContext by componentContext {

    override val entries = listOf(
        LineChartEntry(
            label = "рекомендации",
            Color(red = 111, green = 143, blue = 197),
            listOf(0f, 0f, 0f, 0f, 4f, 0f, 0f, 0f, 1f, 5f, 1f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 0f),
        ),
        LineChartEntry(
            label = "Вконтакте",
            Color(red = 172, green = 134, blue = 214),
            listOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 4f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f),
        ),
        LineChartEntry(
            label = "Instagram",
            Color(red = 172, green = 218, blue = 158),
            listOf(0f, 1f, 0f, 1f, 2f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 1f, 1f, 2f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f),
        ),
        LineChartEntry(
            label = "2Гис",
            Color(red = 149, green = 215, blue = 251),
            listOf(0f, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 2f, 0f, 2f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 0f, 1f),
        ),
    )

}