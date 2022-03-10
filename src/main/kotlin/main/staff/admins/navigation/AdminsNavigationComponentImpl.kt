package main.staff.admins.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component
import main.staff.admins.addAdmin.AddAdminComponentImpl
import main.staff.admins.admin.AdminComponentImpl
import main.staff.admins.admins.AdminsComponentImpl
import network.RepositoryProvider
import network.get

class AdminsNavigationComponentImpl(
    componentContext: ComponentContext,
    repositoryProvider: RepositoryProvider,
) : AdminsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<AdminsDestination, Component> = router(
        initialConfiguration = AdminsDestination.Admins,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                AdminsDestination.Admins -> AdminsComponentImpl(
                    componentContext = componentContext,
                    repository = repositoryProvider.get(),
                )
                AdminsDestination.AddAdmin -> AddAdminComponentImpl(
                    componentContext = componentContext,
                    repository = repositoryProvider.get(),
                )
                is AdminsDestination.Admin -> AdminComponentImpl(
                    componentContext = componentContext,
                    repository = repositoryProvider.get(),
                    id = destination.id
                )
            }
        }
    )

    override val routerState: Value<RouterState<AdminsDestination, Component>> = router.state

    override fun navigateToScreen(destination: AdminsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}