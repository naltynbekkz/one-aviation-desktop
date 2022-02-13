package main.help.support

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface SupportNavigationComponent : Component {
    val routerState: Value<RouterState<SupportDestination, Component>>

    fun navigateToScreen(destination: SupportDestination)
    fun navigateUp()
}