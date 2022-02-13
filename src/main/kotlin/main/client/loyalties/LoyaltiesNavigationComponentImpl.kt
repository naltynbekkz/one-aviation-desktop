package main.client.loyalties

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class LoyaltiesNavigationComponentImpl(
    componentContext: ComponentContext,
) : LoyaltiesNavigationComponent, ComponentContext by componentContext {

    private val router: Router<LoyaltiesDestination, Component> = router(
        initialConfiguration = LoyaltiesDestination.Loyalties,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                LoyaltiesDestination.Loyalties -> LoyaltiesComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<LoyaltiesDestination, Component>> = router.state

    override fun navigateToScreen(destination: LoyaltiesDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}