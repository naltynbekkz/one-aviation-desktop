package main.help.feedback

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class FeedbackNavigationComponentImpl(
    componentContext: ComponentContext,
) : FeedbackNavigationComponent, ComponentContext by componentContext {

    private val router: Router<FeedbackDestination, Component> = router(
        initialConfiguration = FeedbackDestination.Feedback,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                FeedbackDestination.Feedback -> FeedbackComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<FeedbackDestination, Component>> = router.state

    override fun navigateToScreen(destination: FeedbackDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}