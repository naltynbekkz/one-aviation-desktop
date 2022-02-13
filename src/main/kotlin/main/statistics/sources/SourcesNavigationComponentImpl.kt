package main.statistics.sources

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class SourcesNavigationComponentImpl(
    componentContext: ComponentContext,
) : SourcesNavigationComponent, ComponentContext by componentContext {

    private val router: Router<SourcesDestination, Component> = router(
        initialConfiguration = SourcesDestination.Sources,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                SourcesDestination.Sources -> SourcesComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<SourcesDestination, Component>> = router.state

    override fun navigateToScreen(destination: SourcesDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}