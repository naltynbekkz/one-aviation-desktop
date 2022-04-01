package main.statistics.reservationStatistics

import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.pop
import core.CustomComponentContext
import core.router

class ReservationStatisticsNavigationComponent(
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {

    private val router: Router<ReservationStatisticsDestination, CustomComponentContext> = router(
        initialConfiguration = ReservationStatisticsDestination.ReservationStatistics,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                ReservationStatisticsDestination.ReservationStatistics -> ReservationStatisticsComponent(
                    componentContext
                )
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }

    val routerState = router.state

    fun navigateToScreen(destination: ReservationStatisticsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}