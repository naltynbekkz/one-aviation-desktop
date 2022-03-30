package main.statistics.sources

import core.Component
import main.statistics.compose.BarChartEntry
import main.statistics.compose.LineChartEntry

interface SourcesComponent : Component {
    val entries: List<LineChartEntry>
    val revenue: List<BarChartEntry>
    val reservations: List<BarChartEntry>
}