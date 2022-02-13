package main.finance.expense

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface ExpenseNavigationComponent : Component {
    val routerState: Value<RouterState<ExpenseDestination, Component>>

    fun navigateToScreen(destination: ExpenseDestination)
    fun navigateUp()
}