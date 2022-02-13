package main.storage.sales

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class SalesNavigationComponentImpl(
    componentContext: ComponentContext,
) : SalesNavigationComponent, ComponentContext by componentContext {

    private val router: Router<SalesDestination, Component> = router(
        initialConfiguration = SalesDestination.Sales,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                SalesDestination.Sales -> SalesComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<SalesDestination, Component>> = router.state

    override fun navigateToScreen(destination: SalesDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}