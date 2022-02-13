package main.finance.income

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class IncomeNavigationComponentImpl(
    componentContext: ComponentContext,
) : IncomeNavigationComponent, ComponentContext by componentContext {

    private val router: Router<IncomeDestination, Component> = router(
        initialConfiguration = IncomeDestination.Income,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                IncomeDestination.Income -> IncomeComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<IncomeDestination, Component>> = router.state

    override fun navigateToScreen(destination: IncomeDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}