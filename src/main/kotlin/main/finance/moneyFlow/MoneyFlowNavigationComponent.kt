package main.finance.moneyFlow

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface MoneyFlowNavigationComponent : Component {
    val routerState: Value<RouterState<MoneyFlowDestination, Component>>

    fun navigateToScreen(destination: MoneyFlowDestination)
    fun navigateUp()
}