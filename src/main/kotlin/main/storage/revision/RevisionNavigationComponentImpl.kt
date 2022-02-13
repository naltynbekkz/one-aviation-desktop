package main.storage.revision

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class RevisionNavigationComponentImpl(
    componentContext: ComponentContext,
) : RevisionNavigationComponent, ComponentContext by componentContext {

    private val router: Router<RevisionDestination, Component> = router(
        initialConfiguration = RevisionDestination.Revision,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                RevisionDestination.Revision -> RevisionComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<RevisionDestination, Component>> = router.state

    override fun navigateToScreen(destination: RevisionDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}