package main.client.loyalties

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface LoyaltiesNavigationComponent : Component {
    val routerState: Value<RouterState<LoyaltiesDestination, Component>>

    fun navigateToScreen(destination: LoyaltiesDestination)
    fun navigateUp()
}