package main.statistics.marketplace

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface MarketplaceNavigationComponent : Component {
    val routerState: Value<RouterState<MarketplaceDestination, Component>>

    fun navigateToScreen(destination: MarketplaceDestination)
    fun navigateUp()
}