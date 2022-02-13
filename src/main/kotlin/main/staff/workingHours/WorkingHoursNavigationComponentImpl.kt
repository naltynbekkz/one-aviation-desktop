package main.staff.workingHours

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class WorkingHoursNavigationComponentImpl(
    componentContext: ComponentContext,
) : WorkingHoursNavigationComponent, ComponentContext by componentContext {

    private val router: Router<WorkingHoursDestination, Component> = router(
        initialConfiguration = WorkingHoursDestination.WorkingHours,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                WorkingHoursDestination.WorkingHours -> WorkingHoursComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<WorkingHoursDestination, Component>> = router.state

    override fun navigateToScreen(destination: WorkingHoursDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}