package main.client.reservations

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface ReservationsNavigationComponent : Component {
    val routerState: Value<RouterState<ReservationsDestination, Component>>

    fun navigateToScreen(destination: ReservationsDestination)
    fun navigateUp()
}