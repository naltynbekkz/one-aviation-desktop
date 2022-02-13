package main.storage.sales

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface SalesNavigationComponent : Component {
    val routerState: Value<RouterState<SalesDestination, Component>>

    fun navigateToScreen(destination: SalesDestination)
    fun navigateUp()
}