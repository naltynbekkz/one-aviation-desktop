package main.client.reservations

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class ReservationsNavigationComponentImpl(
    componentContext: ComponentContext,
) : ReservationsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<ReservationsDestination, Component> = router(
        initialConfiguration = ReservationsDestination.Reservations,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                ReservationsDestination.Reservations -> ReservationsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<ReservationsDestination, Component>> = router.state

    override fun navigateToScreen(destination: ReservationsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}