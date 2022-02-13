package main.statistics.reservationStatistics

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class ReservationStatisticsNavigationComponentImpl(
    componentContext: ComponentContext,
) : ReservationStatisticsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<ReservationStatisticsDestination, Component> = router(
        initialConfiguration = ReservationStatisticsDestination.ReservationStatistics,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                ReservationStatisticsDestination.ReservationStatistics -> ReservationStatisticsComponentImpl(
                    componentContext
                )
            }
        }
    )

    override val routerState: Value<RouterState<ReservationStatisticsDestination, Component>> = router.state

    override fun navigateToScreen(destination: ReservationStatisticsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}