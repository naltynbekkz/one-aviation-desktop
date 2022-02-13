package main.logs

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface LogsNavigationComponent : Component {
    val routerState: Value<RouterState<LogsDestination, Component>>

    fun navigateToScreen(destination: LogsDestination)
    fun navigateUp()
}