package main.logs

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class LogsNavigationComponentImpl(
    componentContext: ComponentContext,
) : LogsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<LogsDestination, Component> = router(
        initialConfiguration = LogsDestination.Logs,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                LogsDestination.Logs -> LogsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<LogsDestination, Component>> = router.state

    override fun navigateToScreen(destination: LogsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}