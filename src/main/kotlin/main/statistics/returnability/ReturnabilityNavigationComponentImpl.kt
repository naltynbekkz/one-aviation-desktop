package main.statistics.returnability

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class ReturnabilityNavigationComponentImpl(
    componentContext: ComponentContext,
) : ReturnabilityNavigationComponent, ComponentContext by componentContext {

    private val router: Router<ReturnabilityDestination, Component> = router(
        initialConfiguration = ReturnabilityDestination.Returnability,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                ReturnabilityDestination.Returnability -> ReturnabilityComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<ReturnabilityDestination, Component>> = router.state

    override fun navigateToScreen(destination: ReturnabilityDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}