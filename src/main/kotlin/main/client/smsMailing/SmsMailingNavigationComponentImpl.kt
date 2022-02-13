package main.client.smsMailing

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class SmsMailingNavigationComponentImpl(
    componentContext: ComponentContext,
) : SmsMailingNavigationComponent, ComponentContext by componentContext {

    private val router: Router<SmsMailingDestination, Component> = router(
        initialConfiguration = SmsMailingDestination.SmsMailing,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                SmsMailingDestination.SmsMailing -> SmsMailingComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<SmsMailingDestination, Component>> = router.state

    override fun navigateToScreen(destination: SmsMailingDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}