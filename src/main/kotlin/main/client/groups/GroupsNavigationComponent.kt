package main.client.groups

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface GroupsNavigationComponent : Component {
    val routerState: Value<RouterState<GroupsDestination, Component>>

    fun navigateToScreen(destination: GroupsDestination)
    fun navigateUp()
}