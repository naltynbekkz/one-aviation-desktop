package main.statistics.serviceStatistics

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class ServiceStatisticsNavigationComponentImpl(
    componentContext: ComponentContext,
) : ServiceStatisticsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<ServiceStatisticsDestination, Component> = router(
        initialConfiguration = ServiceStatisticsDestination.ServiceStatistics,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                ServiceStatisticsDestination.ServiceStatistics -> ServiceStatisticsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<ServiceStatisticsDestination, Component>> = router.state

    override fun navigateToScreen(destination: ServiceStatisticsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}