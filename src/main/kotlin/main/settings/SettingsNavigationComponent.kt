package main.settings

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface SettingsNavigationComponent : Component {
    val routerState: Value<RouterState<SettingsDestination, Component>>

    fun navigateToScreen(destination: SettingsDestination)
    fun navigateUp()
}