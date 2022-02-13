package main.finance.reports

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface ReportsNavigationComponent : Component {
    val routerState: Value<RouterState<ReportsDestination, Component>>

    fun navigateToScreen(destination: ReportsDestination)
    fun navigateUp()
}