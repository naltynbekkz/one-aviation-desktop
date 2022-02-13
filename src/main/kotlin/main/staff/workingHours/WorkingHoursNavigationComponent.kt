package main.staff.workingHours

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface WorkingHoursNavigationComponent : Component {
    val routerState: Value<RouterState<WorkingHoursDestination, Component>>

    fun navigateToScreen(destination: WorkingHoursDestination)
    fun navigateUp()
}