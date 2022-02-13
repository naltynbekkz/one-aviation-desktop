package main.help.support

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class SupportNavigationComponentImpl(
    componentContext: ComponentContext,
) : SupportNavigationComponent, ComponentContext by componentContext {

    private val router: Router<SupportDestination, Component> = router(
        initialConfiguration = SupportDestination.Support,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                SupportDestination.Support -> SupportComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<SupportDestination, Component>> = router.state

    override fun navigateToScreen(destination: SupportDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}