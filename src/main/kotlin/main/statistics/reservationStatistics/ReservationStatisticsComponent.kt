package main.statistics.reservationStatistics

import core.Component
import main.statistics.compose.HorizontalBarChartEntry

interface ReservationStatisticsComponent : Component {
    val mastersRevenueEntries: List<HorizontalBarChartEntry>
    val mastersReservationsEntries: List<HorizontalBarChartEntry>
}