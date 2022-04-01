package main.client.clients

import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.pop
import core.CustomComponentContext
import core.router

class ClientsNavigationComponent(
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {

    private val router: Router<ClientsDestination, CustomComponentContext> = router(
        initialConfiguration = ClientsDestination.Clients,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                ClientsDestination.Clients -> ClientsComponent(componentContext)
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }

    val routerState = router.state

    fun navigateToScreen(destination: ClientsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}