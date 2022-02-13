package main.client.clients

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class ClientsNavigationComponentImpl(
    componentContext: ComponentContext,
) : ClientsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<ClientsDestination, Component> = router(
        initialConfiguration = ClientsDestination.Clients,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                ClientsDestination.Clients -> ClientsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<ClientsDestination, Component>> = router.state

    override fun navigateToScreen(destination: ClientsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}