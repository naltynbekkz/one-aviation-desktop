package main.profile.navigation

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component
import main.profile.ProfileDestination

interface ProfileNavigationComponent : Component {
    val routerState: Value<RouterState<ProfileDestination, Component>>

    fun navigateToScreen(destination: ProfileDestination)
    fun navigateUp()
}