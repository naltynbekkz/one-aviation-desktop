package main.settings.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface SettingsNavigationComponent : Component {
    val routerState: Value<RouterState<SettingsDestination, ComponentContext>>

    fun navigateToScreen(destination: SettingsDestination)
    fun navigateUp()
}