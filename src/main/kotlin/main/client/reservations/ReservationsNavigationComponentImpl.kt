package main.client.reservations

import core.CustomComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import core.router
import com.arkivanov.decompose.value.Value
import core.Component

class ReservationsNavigationComponent(
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {

    private val router: Router<ReservationsDestination, CustomComponentContext> = router(
        initialConfiguration = ReservationsDestination.Reservations,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                ReservationsDestination.Reservations -> ReservationsComponent(componentContext)
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }
    
    val routerState = router.state

    fun navigateToScreen(destination: ReservationsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}