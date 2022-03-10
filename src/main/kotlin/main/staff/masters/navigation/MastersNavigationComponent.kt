package main.staff.masters.navigation

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface MastersNavigationComponent : Component {
    val routerState: Value<RouterState<MastersDestination, Component>>

    fun navigateToScreen(destination: MastersDestination)
    fun navigateUp()
}