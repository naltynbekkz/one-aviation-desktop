package main.client.notifications

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class NotificationsNavigationComponentImpl(
    componentContext: ComponentContext,
) : NotificationsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<NotificationsDestination, Component> = router(
        initialConfiguration = NotificationsDestination.Notifications,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                NotificationsDestination.Notifications -> NotificationsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<NotificationsDestination, Component>> = router.state

    override fun navigateToScreen(destination: NotificationsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}