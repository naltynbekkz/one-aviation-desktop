package main.statistics.marketplace

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class MarketplaceNavigationComponentImpl(
    componentContext: ComponentContext,
) : MarketplaceNavigationComponent, ComponentContext by componentContext {

    private val router: Router<MarketplaceDestination, Component> = router(
        initialConfiguration = MarketplaceDestination.Marketplace,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                MarketplaceDestination.Marketplace -> MarketplaceComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<MarketplaceDestination, Component>> = router.state

    override fun navigateToScreen(destination: MarketplaceDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}