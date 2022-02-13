package main.statistics.clientStatistics

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class ClientStatisticsNavigationComponentImpl(
    componentContext: ComponentContext,
) : ClientStatisticsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<ClientStatisticsDestination, Component> = router(
        initialConfiguration = ClientStatisticsDestination.ClientStatistics,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                ClientStatisticsDestination.ClientStatistics -> ClientStatisticsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<ClientStatisticsDestination, Component>> = router.state

    override fun navigateToScreen(destination: ClientStatisticsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}