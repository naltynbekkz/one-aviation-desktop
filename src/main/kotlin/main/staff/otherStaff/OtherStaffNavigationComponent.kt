package main.staff.otherStaff

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface OtherStaffNavigationComponent : Component {
    val routerState: Value<RouterState<OtherStaffDestination, Component>>

    fun navigateToScreen(destination: OtherStaffDestination)
    fun navigateUp()
}