package main.statistics.mapStatistics

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface MapStatisticsNavigationComponent : Component {
    val routerState: Value<RouterState<MapStatisticsDestination, Component>>

    fun navigateToScreen(destination: MapStatisticsDestination)
    fun navigateUp()
}