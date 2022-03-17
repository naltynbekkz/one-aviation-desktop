package main.staff.masters.navigation

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component
import core.Interactor
import main.staff.masters.data.Plane

interface MastersNavigationComponent : Component {
    val routerState: Value<RouterState<MastersDestination, Component>>

    fun navigateToScreen(destination: MastersDestination)
    fun navigateUp()
}