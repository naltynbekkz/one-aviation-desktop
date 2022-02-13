package main.service.services

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface ServicesNavigationComponent : Component {
    val routerState: Value<RouterState<ServicesDestination, Component>>

    fun navigateToScreen(destination: ServicesDestination)
    fun navigateUp()
}