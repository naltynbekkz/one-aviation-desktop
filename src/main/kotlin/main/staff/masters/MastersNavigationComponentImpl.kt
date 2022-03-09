package main.staff.masters

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component
import main.staff.masters.addMaster.AddMasterComponentImpl
import network.RepositoryProvider
import network.get

class MastersNavigationComponentImpl(
    componentContext: ComponentContext,
    repositoryProvider: RepositoryProvider,
) : MastersNavigationComponent, ComponentContext by componentContext {

    private val router: Router<MastersDestination, Component> = router(
        initialConfiguration = MastersDestination.Masters,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                MastersDestination.Masters -> MastersComponentImpl(
                    componentContext = componentContext,
                    repository = repositoryProvider.get()
                )
                MastersDestination.AddMaster -> AddMasterComponentImpl(
                    componentContext = componentContext,
                    repository = repositoryProvider.get()
                )
            }
        }
    )

    override val routerState: Value<RouterState<MastersDestination, Component>> = router.state

    override fun navigateToScreen(destination: MastersDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}