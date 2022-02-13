package main.statistics.mapStatistics

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class MapStatisticsNavigationComponentImpl(
    componentContext: ComponentContext,
) : MapStatisticsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<MapStatisticsDestination, Component> = router(
        initialConfiguration = MapStatisticsDestination.MapStatistics,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                MapStatisticsDestination.MapStatistics -> MapStatisticsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<MapStatisticsDestination, Component>> = router.state

    override fun navigateToScreen(destination: MapStatisticsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}