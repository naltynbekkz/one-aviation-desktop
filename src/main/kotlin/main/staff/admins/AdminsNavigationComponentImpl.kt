package main.staff.admins

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class AdminsNavigationComponentImpl(
    componentContext: ComponentContext,
) : AdminsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<AdminsDestination, Component> = router(
        initialConfiguration = AdminsDestination.Admins,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                AdminsDestination.Admins -> AdminsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<AdminsDestination, Component>> = router.state

    override fun navigateToScreen(destination: AdminsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}