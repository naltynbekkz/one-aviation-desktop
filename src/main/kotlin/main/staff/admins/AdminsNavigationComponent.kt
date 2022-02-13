package main.staff.admins

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface AdminsNavigationComponent : Component {
    val routerState: Value<RouterState<AdminsDestination, Component>>

    fun navigateToScreen(destination: AdminsDestination)
    fun navigateUp()
}