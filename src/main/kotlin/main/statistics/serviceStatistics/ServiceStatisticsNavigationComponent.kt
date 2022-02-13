package main.statistics.serviceStatistics

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface ServiceStatisticsNavigationComponent : Component {
    val routerState: Value<RouterState<ServiceStatisticsDestination, Component>>

    fun navigateToScreen(destination: ServiceStatisticsDestination)
    fun navigateUp()
}