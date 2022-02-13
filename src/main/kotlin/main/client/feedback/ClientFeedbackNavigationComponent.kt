package main.client.feedback

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface ClientFeedbackNavigationComponent : Component {
    val routerState: Value<RouterState<ClientFeedbackDestination, Component>>

    fun navigateToScreen(destination: ClientFeedbackDestination)
    fun navigateUp()
}