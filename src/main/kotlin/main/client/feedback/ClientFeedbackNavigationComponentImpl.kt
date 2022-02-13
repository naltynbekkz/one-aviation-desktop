package main.client.feedback

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class ClientFeedbackNavigationComponentImpl(
    componentContext: ComponentContext,
) : ClientFeedbackNavigationComponent, ComponentContext by componentContext {

    private val router: Router<ClientFeedbackDestination, Component> = router(
        initialConfiguration = ClientFeedbackDestination.ClientFeedback,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                ClientFeedbackDestination.ClientFeedback -> ClientFeedbackComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<ClientFeedbackDestination, Component>> = router.state

    override fun navigateToScreen(destination: ClientFeedbackDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}