package main.statistics.clientStatistics

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface ClientStatisticsNavigationComponent : Component {
    val routerState: Value<RouterState<ClientStatisticsDestination, Component>>

    fun navigateToScreen(destination: ClientStatisticsDestination)
    fun navigateUp()
}