package main.client.clients

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface ClientsNavigationComponent : Component {
    val routerState: Value<RouterState<ClientsDestination, Component>>

    fun navigateToScreen(destination: ClientsDestination)
    fun navigateUp()
}