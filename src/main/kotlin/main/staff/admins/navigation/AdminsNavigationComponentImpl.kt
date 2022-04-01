package main.staff.admins.navigation

import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.pop
import core.CustomComponentContext
import core.router
import main.staff.admins.addAdmin.AddAdminComponent
import main.staff.admins.admin.AdminComponent
import main.staff.admins.admins.AdminsComponent
import network.RepositoryProvider
import network.get

class AdminsNavigationComponent(
    customComponentContext: CustomComponentContext,
    repositoryProvider: RepositoryProvider,
) : CustomComponentContext by customComponentContext {

    private val router: Router<AdminsDestination, CustomComponentContext> = router(
        initialConfiguration = AdminsDestination.Admins,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                AdminsDestination.Admins -> AdminsComponent(
                    customComponentContext = componentContext,
                    repository = repositoryProvider.get(),
                )
                AdminsDestination.AddAdmin -> AddAdminComponent(
                    customComponentContext = componentContext,
                    repository = repositoryProvider.get(),
                )
                is AdminsDestination.Admin -> AdminComponent(
                    customComponentContext = componentContext,
                    repository = repositoryProvider.get(),
                    id = destination.id
                )
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }

    val routerState = router.state

    fun navigateToScreen(destination: AdminsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}