package main.finance.expense

import core.CustomComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import core.router
import com.arkivanov.decompose.value.Value
import core.Component

class ExpenseNavigationComponent(
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {

    private val router: Router<ExpenseDestination, CustomComponentContext> = router(
        initialConfiguration = ExpenseDestination.Expense,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                ExpenseDestination.Expense -> ExpenseComponent(componentContext)
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }
    
    val routerState = router.state

    fun navigateToScreen(destination: ExpenseDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}