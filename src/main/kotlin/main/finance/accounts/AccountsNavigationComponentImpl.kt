package main.finance.accounts

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class AccountsNavigationComponentImpl(
    componentContext: ComponentContext,
) : AccountsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<AccountsDestination, Component> = router(
        initialConfiguration = AccountsDestination.Accounts,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                AccountsDestination.Accounts -> AccountsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<AccountsDestination, Component>> = router.state

    override fun navigateToScreen(destination: AccountsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}