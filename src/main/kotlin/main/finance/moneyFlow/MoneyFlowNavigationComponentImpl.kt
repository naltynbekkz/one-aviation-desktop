package main.finance.moneyFlow

import core.CustomComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import core.router
import com.arkivanov.decompose.value.Value
import core.Component

class MoneyFlowNavigationComponent(
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {

    private val router: Router<MoneyFlowDestination, CustomComponentContext> = router(
        initialConfiguration = MoneyFlowDestination.MoneyFlow,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                MoneyFlowDestination.MoneyFlow -> MoneyFlowComponent(componentContext)
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }
    
    val routerState = router.state

    fun navigateToScreen(destination: MoneyFlowDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}