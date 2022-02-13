package main.client.notifications

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface NotificationsNavigationComponent : Component {
    val routerState: Value<RouterState<NotificationsDestination, Component>>

    fun navigateToScreen(destination: NotificationsDestination)
    fun navigateUp()
}