package main.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class HomeNavigationComponentImpl(
    componentContext: ComponentContext,
) : HomeNavigationComponent, ComponentContext by componentContext {

    private val router: Router<HomeDestination, Component> = router(
        initialConfiguration = HomeDestination.Home,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                HomeDestination.Home -> HomeComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<HomeDestination, Component>> = router.state

    override fun navigateToScreen(destination: HomeDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}