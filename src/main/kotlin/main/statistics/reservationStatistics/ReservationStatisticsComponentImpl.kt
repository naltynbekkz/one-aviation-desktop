package main.statistics.reservationStatistics

import com.arkivanov.decompose.ComponentContext
import main.statistics.compose.HorizontalBarChartEntry

class ReservationStatisticsComponentImpl(
    componentContext: ComponentContext,
) : ReservationStatisticsComponent, ComponentContext by componentContext {
    override val mastersRevenueEntries = listOf(
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

    override val mastersReservationsEntries = listOf(
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