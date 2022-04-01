package main.staff.masters.navigation

import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.pop
import core.CustomComponentContext
import core.router
import main.staff.masters.addMaster.AddMasterComponent
import main.staff.masters.master.MasterComponent
import main.staff.masters.masters.MastersComponent
import network.RepositoryProvider
import network.get

class MastersNavigationComponent(
    customComponentContext: CustomComponentContext,
    repositoryProvider: RepositoryProvider,
) : CustomComponentContext by customComponentContext {

    private val router: Router<MastersDestination, CustomComponentContext> = router(
        initialConfiguration = MastersDestination.Masters,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                MastersDestination.Masters -> MastersComponent(
                    customComponentContext = componentContext,
                    repository = repositoryProvider.get()
                )
                is MastersDestination.Master -> MasterComponent(
                    customComponentContext = componentContext,
                    repository = repositoryProvider.get(),
                    id = destination.id,
                )
                MastersDestination.AddMaster -> AddMasterComponent(
                    customComponentContext = componentContext,
                    repository = repositoryProvider.get()
                )
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }

    val routerState = router.state

    fun navigateToScreen(destination: MastersDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}