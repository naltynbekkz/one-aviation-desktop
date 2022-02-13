package main.storage.turnover

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class TurnoverNavigationComponentImpl(
    componentContext: ComponentContext,
) : TurnoverNavigationComponent, ComponentContext by componentContext {

    private val router: Router<TurnoverDestination, Component> = router(
        initialConfiguration = TurnoverDestination.Turnover,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                TurnoverDestination.Turnover -> TurnoverComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<TurnoverDestination, Component>> = router.state

    override fun navigateToScreen(destination: TurnoverDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}