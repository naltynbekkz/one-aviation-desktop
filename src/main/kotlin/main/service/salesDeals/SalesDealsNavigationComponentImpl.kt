package main.service.salesDeals

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class SalesDealsNavigationComponentImpl(
    componentContext: ComponentContext,
) : SalesDealsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<SalesDealsDestination, Component> = router(
        initialConfiguration = SalesDealsDestination.SalesDeals,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                SalesDealsDestination.SalesDeals -> SalesDealsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<SalesDealsDestination, Component>> = router.state

    override fun navigateToScreen(destination: SalesDealsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}