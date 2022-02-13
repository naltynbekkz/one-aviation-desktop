package main.help.documentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class DocumentationNavigationComponentImpl(
    componentContext: ComponentContext,
) : DocumentationNavigationComponent, ComponentContext by componentContext {

    private val router: Router<DocumentationDestination, Component> = router(
        initialConfiguration = DocumentationDestination.Documentation,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                DocumentationDestination.Documentation -> DocumentationComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<DocumentationDestination, Component>> = router.state

    override fun navigateToScreen(destination: DocumentationDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}