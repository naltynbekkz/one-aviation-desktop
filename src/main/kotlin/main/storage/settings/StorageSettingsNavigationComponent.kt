package main.storage.settings

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface StorageSettingsNavigationComponent : Component {
    val routerState: Value<RouterState<StorageSettingsDestination, Component>>

    fun navigateToScreen(destination: StorageSettingsDestination)
    fun navigateUp()
}