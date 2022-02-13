package main.finance.income

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface IncomeNavigationComponent : Component {
    val routerState: Value<RouterState<IncomeDestination, Component>>

    fun navigateToScreen(destination: IncomeDestination)
    fun navigateUp()
}