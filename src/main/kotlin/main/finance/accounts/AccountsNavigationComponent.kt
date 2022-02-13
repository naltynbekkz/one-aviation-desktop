package main.finance.accounts

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface AccountsNavigationComponent : Component {
    val routerState: Value<RouterState<AccountsDestination, Component>>

    fun navigateToScreen(destination: AccountsDestination)
    fun navigateUp()
}