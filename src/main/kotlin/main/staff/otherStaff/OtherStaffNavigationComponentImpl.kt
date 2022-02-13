package main.staff.otherStaff

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class OtherStaffNavigationComponentImpl(
    componentContext: ComponentContext,
) : OtherStaffNavigationComponent, ComponentContext by componentContext {

    private val router: Router<OtherStaffDestination, Component> = router(
        initialConfiguration = OtherStaffDestination.OtherStaff,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                OtherStaffDestination.OtherStaff -> OtherStaffComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<OtherStaffDestination, Component>> = router.state

    override fun navigateToScreen(destination: OtherStaffDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}