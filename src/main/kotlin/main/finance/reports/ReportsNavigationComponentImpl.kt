package main.finance.reports

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class ReportsNavigationComponentImpl(
    componentContext: ComponentContext,
) : ReportsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<ReportsDestination, Component> = router(
        initialConfiguration = ReportsDestination.Reports,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                ReportsDestination.Reports -> ReportsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<ReportsDestination, Component>> = router.state

    override fun navigateToScreen(destination: ReportsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}