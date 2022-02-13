package main.profile.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component
import main.profile.profile.ProfileComponentImpl
import main.profile.ProfileDestination
import main.profile.changePassword.ChangePasswordComponentImpl
import settings.SettingsProvider
import settings.get

class ProfileNavigationComponentImpl(
    componentContext: ComponentContext,
    private val settingsProvider: SettingsProvider,
) : ProfileNavigationComponent, ComponentContext by componentContext {

    private val router: Router<ProfileDestination, Component> = router(
        initialConfiguration = ProfileDestination.Profile,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                ProfileDestination.Profile -> ProfileComponentImpl(componentContext, settingsProvider.get())
                ProfileDestination.ChangePassword -> ChangePasswordComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<ProfileDestination, Component>> = router.state

    override fun navigateToScreen(destination: ProfileDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}