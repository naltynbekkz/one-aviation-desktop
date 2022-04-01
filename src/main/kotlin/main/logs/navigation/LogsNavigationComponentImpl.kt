package main.logs.navigation

import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.pop
import core.CustomComponentContext
import core.router
import main.logs.logs.LogsComponent
import main.logs.reservation.ReservationComponent
import network.RepositoryProvider
import network.get

class LogsNavigationComponent(
    customComponentContext: CustomComponentContext,
    repositoryProvider: RepositoryProvider,
) : CustomComponentContext by customComponentContext {

    private val router: Router<LogsDestination, CustomComponentContext> = router(
        initialConfiguration = LogsDestination.Logs,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                LogsDestination.Logs -> LogsComponent(
                    customComponentContext = componentContext,
                    repository = repositoryProvider.get(),
                )
                is LogsDestination.Reservation -> ReservationComponent(
                    customComponentContext = componentContext,
                    id = destination.id,
                    repository = repositoryProvider.get(),
                )
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }

    val routerState = router.state

    fun navigateToScreen(destination: LogsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}