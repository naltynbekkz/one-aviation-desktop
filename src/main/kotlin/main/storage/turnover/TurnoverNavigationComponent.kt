package main.storage.turnover

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface TurnoverNavigationComponent : Component {
    val routerState: Value<RouterState<TurnoverDestination, Component>>

    fun navigateToScreen(destination: TurnoverDestination)
    fun navigateUp()
}