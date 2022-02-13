package main.client.smsMailing

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface SmsMailingNavigationComponent : Component {
    val routerState: Value<RouterState<SmsMailingDestination, Component>>

    fun navigateToScreen(destination: SmsMailingDestination)
    fun navigateUp()
}