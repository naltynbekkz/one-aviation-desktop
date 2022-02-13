package main.finance.moneyFlow

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class MoneyFlowNavigationComponentImpl(
    componentContext: ComponentContext,
) : MoneyFlowNavigationComponent, ComponentContext by componentContext {

    private val router: Router<MoneyFlowDestination, Component> = router(
        initialConfiguration = MoneyFlowDestination.MoneyFlow,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                MoneyFlowDestination.MoneyFlow -> MoneyFlowComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<MoneyFlowDestination, Component>> = router.state

    override fun navigateToScreen(destination: MoneyFlowDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}