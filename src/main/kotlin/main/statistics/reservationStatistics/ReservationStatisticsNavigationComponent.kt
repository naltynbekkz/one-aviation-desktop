package main.statistics.reservationStatistics

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface ReservationStatisticsNavigationComponent : Component {
    val routerState: Value<RouterState<ReservationStatisticsDestination, Component>>

    fun navigateToScreen(destination: ReservationStatisticsDestination)
    fun navigateUp()
}