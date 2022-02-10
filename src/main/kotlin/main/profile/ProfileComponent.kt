package main.profile

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface ProfileComponent : Component {

    val routerState: Value<RouterState<ProfileDestination, Component>>

    fun navigateToScreen(profileDestination: ProfileDestination)
    fun navigateUp()

}