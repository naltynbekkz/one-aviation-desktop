package main.service.salesDeals

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface SalesDealsNavigationComponent : Component {
    val routerState: Value<RouterState<SalesDealsDestination, Component>>

    fun navigateToScreen(destination: SalesDealsDestination)
    fun navigateUp()
}