package main.statistics.returnability

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface ReturnabilityNavigationComponent : Component {
    val routerState: Value<RouterState<ReturnabilityDestination, Component>>

    fun navigateToScreen(destination: ReturnabilityDestination)
    fun navigateUp()
}