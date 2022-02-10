package main.profile

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component
import development.InDevelopmentComponent
import main.profile.changePassword.ChangePasswordComponentImpl
import main.profile.profile.ProfileScreenComponentImpl
import settings.SettingsProvider
import settings.get

class ProfileComponentImpl(
    componentContext: ComponentContext,
    private val settingsProvider: SettingsProvider,
) : ProfileComponent, ComponentContext by componentContext {

    private val router: Router<ProfileDestination, Component> = router(
        initialConfiguration = ProfileDestination.Profile,
        handleBackButton = true,
        childFactory = ::resolveChild
    )

    override val routerState: Value<RouterState<ProfileDestination, Component>> = router.state

    private fun resolveChild(mainDestination: ProfileDestination, componentContext: ComponentContext): Component =
        when (mainDestination) {
            ProfileDestination.Profile -> ProfileScreenComponentImpl(componentContext, settingsProvider.get())
            ProfileDestination.ChangePassword -> ChangePasswordComponentImpl(componentContext)
            else -> InDevelopmentComponent(componentContext)
        }

    override fun navigateToScreen(profileDestination: ProfileDestination) {
        router.navigate { list ->
            list + profileDestination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}