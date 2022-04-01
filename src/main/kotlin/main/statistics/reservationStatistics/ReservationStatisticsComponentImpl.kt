package main.statistics.reservationStatistics

import main.statistics.compose.BarChartEntry
import core.CustomComponentContext

class ReservationStatisticsComponent(
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {
    val mastersRevenueEntries = listOf(
        BarChartEntry(
            label = "Камилла",
            value = 11400f,
        ),
        BarChartEntry(
            label = "Инна",
            value = 5000f,
        ),
        BarChartEntry(
            label = "Фарида",
            value = 3000f,
        ),
    )

    val mastersReservationsEntries = listOf(
                BarChartEntry(
            label = "Камилла",
            value = 3f,
        ),
        BarChartEntry(
            label = "Фарида",
            value = 2f,
        ),
        BarChartEntry(
            label = "Инна",
            value = 1f,
        ),
    )

    val revenueEntries = listOf(
        BarChartEntry(
            label = "28 мар",
            value = 6000f,
        ),
        BarChartEntry(
            label = "29 мар",
            value = 100f,
        ),
        BarChartEntry(
            label = "30 мар",
            value = 100f,
        ),
        BarChartEntry(
            label = "31 мар",
            value = 100f,
        ),
        BarChartEntry(
            label = "01 апр.",
            value = 100f,
        ),
        BarChartEntry(
            label = "02 апр.",
            value = 100f,
        ),
        BarChartEntry(
            label = "03 апр.",
            value = 100f,
        ),
    )

}