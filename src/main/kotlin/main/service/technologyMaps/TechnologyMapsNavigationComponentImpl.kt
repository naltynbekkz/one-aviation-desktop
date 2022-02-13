package main.service.technologyMaps

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class TechnologyMapsNavigationComponentImpl(
    componentContext: ComponentContext,
) : TechnologyMapsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<TechnologyMapsDestination, Component> = router(
        initialConfiguration = TechnologyMapsDestination.TechnologyMaps,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                TechnologyMapsDestination.TechnologyMaps -> TechnologyMapsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<TechnologyMapsDestination, Component>> = router.state

    override fun navigateToScreen(destination: TechnologyMapsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}