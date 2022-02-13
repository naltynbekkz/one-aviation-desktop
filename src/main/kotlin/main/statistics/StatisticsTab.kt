package main.statistics

import main.MainTab
import main.MainTabGroup

object StatisticsTab : MainTabGroup("Statistics") {
    object ReservationStatistics : MainTab("ReservationStatistics")
    object Sources : MainTab("Sources")
    object ServiceStatistics : MainTab("ServiceStatistics")
    object MapStatistics : MainTab("MapStatistics")
    object ClientStatistics : MainTab("ClientStatistics")
    object Returnability : MainTab("Returnability")
    object Marketplace : MainTab("Marketplace")

    override val destinations = listOf(
        ReservationStatistics,
        Sources,
        ServiceStatistics,
        MapStatistics,
        ClientStatistics,
        Returnability,
        Marketplace,
    )
}