package main.profile.navigation

import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.pop
import core.CustomComponentContext
import core.router
import main.profile.changePassword.ChangePasswordComponent
import main.profile.editProfile.EditProfileComponent
import main.profile.profile.ProfileComponent
import network.RepositoryProvider
import network.get
import settings.SettingsProvider
import settings.get

class ProfileNavigationComponent(
    customComponentContext: CustomComponentContext,
    private val settingsProvider: SettingsProvider,
    private val repositoryProvider: RepositoryProvider,
) : CustomComponentContext by customComponentContext {

    private val router: Router<ProfileDestination, CustomComponentContext> = router(
        initialConfiguration = ProfileDestination.Profile,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                ProfileDestination.Profile -> ProfileComponent(
                    componentContext,
                    repositoryProvider.get(),
                    settingsProvider.get()
                )
                ProfileDestination.ChangePassword -> ChangePasswordComponent(componentContext)
                ProfileDestination.EditProfile -> EditProfileComponent(componentContext)
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }

    val routerState = router.state

    fun navigateToScreen(destination: ProfileDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}