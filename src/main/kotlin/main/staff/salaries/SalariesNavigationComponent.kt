package main.staff.salaries

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface SalariesNavigationComponent : Component {
    val routerState: Value<RouterState<SalariesDestination, Component>>

    fun navigateToScreen(destination: SalariesDestination)
    fun navigateUp()
}