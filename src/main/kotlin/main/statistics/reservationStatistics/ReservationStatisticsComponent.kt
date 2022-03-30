package main.statistics.reservationStatistics

import core.Component
import main.statistics.compose.BarChartEntry

interface ReservationStatisticsComponent : Component {
    val mastersRevenueEntries: List<BarChartEntry>
    val mastersReservationsEntries: List<BarChartEntry>
    val revenueEntries: List<BarChartEntry>
}