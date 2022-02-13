package main.service.services

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class ServicesNavigationComponentImpl(
    componentContext: ComponentContext,
) : ServicesNavigationComponent, ComponentContext by componentContext {

    private val router: Router<ServicesDestination, Component> = router(
        initialConfiguration = ServicesDestination.Services,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                ServicesDestination.Services -> ServicesComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<ServicesDestination, Component>> = router.state

    override fun navigateToScreen(destination: ServicesDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}