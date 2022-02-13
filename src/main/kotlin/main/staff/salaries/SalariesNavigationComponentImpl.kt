package main.staff.salaries

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class SalariesNavigationComponentImpl(
    componentContext: ComponentContext,
) : SalariesNavigationComponent, ComponentContext by componentContext {

    private val router: Router<SalariesDestination, Component> = router(
        initialConfiguration = SalariesDestination.Salaries,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                SalariesDestination.Salaries -> SalariesComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<SalariesDestination, Component>> = router.state

    override fun navigateToScreen(destination: SalariesDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}