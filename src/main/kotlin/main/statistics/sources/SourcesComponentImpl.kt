package main.statistics.sources

import androidx.compose.ui.graphics.Color
import core.CustomComponentContext
import main.statistics.compose.BarChartEntry
import main.statistics.compose.LineChartEntry

class SourcesComponent(
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {

    val entries = listOf(
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

    val revenue = listOf(
        BarChartEntry("2Гис", 25000f),
        BarChartEntry("Instagram", 30000f),
        BarChartEntry("ВКонтакте", 1000f),
        BarChartEntry("Друзья", 0f),
        BarChartEntry("Коллеги", 20000f),
        BarChartEntry("рекомендации", 230000f),
        BarChartEntry("Сарафанное радио", 0f),
        BarChartEntry("Таргет", 0f),
    )

    val reservations = listOf(
        BarChartEntry("2Гис", 7f),
        BarChartEntry("Instagram", 10f),
        BarChartEntry("ВКонтакте", 4f),
        BarChartEntry("Друзья", 0f),
        BarChartEntry("Коллеги", 3f),
        BarChartEntry("рекомендации", 13f),
        BarChartEntry("Сарафанное радио", 0f),
        BarChartEntry("Таргет", 0f),
    )
}