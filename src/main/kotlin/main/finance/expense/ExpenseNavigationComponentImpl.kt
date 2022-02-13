package main.finance.expense

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class ExpenseNavigationComponentImpl(
    componentContext: ComponentContext,
) : ExpenseNavigationComponent, ComponentContext by componentContext {

    private val router: Router<ExpenseDestination, Component> = router(
        initialConfiguration = ExpenseDestination.Expense,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                ExpenseDestination.Expense -> ExpenseComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<ExpenseDestination, Component>> = router.state

    override fun navigateToScreen(destination: ExpenseDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}