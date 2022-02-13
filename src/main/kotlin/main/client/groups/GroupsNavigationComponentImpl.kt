package main.client.groups

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class GroupsNavigationComponentImpl(
    componentContext: ComponentContext,
) : GroupsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<GroupsDestination, Component> = router(
        initialConfiguration = GroupsDestination.Groups,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                GroupsDestination.Groups -> GroupsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<GroupsDestination, Component>> = router.state

    override fun navigateToScreen(destination: GroupsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}