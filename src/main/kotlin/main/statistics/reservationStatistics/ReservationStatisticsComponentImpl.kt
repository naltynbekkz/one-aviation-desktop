package main.statistics.reservationStatistics

import core.CustomComponentContext
import main.statistics.compose.HorizontalBarChartEntry

class ReservationStatisticsComponent(
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {
    val mastersRevenueEntries = listOf(
        HorizontalBarChartEntry(
            label = "Камилла",
            value = 11400f,
        ),
        HorizontalBarChartEntry(
            label = "Инна",
            value = 5000f,
        ),
        HorizontalBarChartEntry(
            label = "Фарида",
            value = 3000f,
        ),
    )

    val mastersReservationsEntries = listOf(
        HorizontalBarChartEntry(
            label = "Камилла",
            value = 3f,
        ),
        HorizontalBarChartEntry(
            label = "Фарида",
            value = 2f,
        ),
        HorizontalBarChartEntry(
            label = "Инна",
            value = 1f,
        ),
    )

}