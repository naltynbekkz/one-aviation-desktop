package root

import auth.AuthComponent
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.pop
import core.CoreSettings
import core.CustomComponentContext
import core.router
import main.MainComponent
import network.RepositoryProvider
import settings.SettingsProvider
import settings.get

class RootComponent(
    private val repositoryProvider: RepositoryProvider,
    private val settingsProvider: SettingsProvider,
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {

    val refreshToken = settingsProvider.get<CoreSettings>().refreshToken

    private val router: Router<RootDestination, CustomComponentContext> = router(
        initialConfiguration = if (refreshToken.value == null) RootDestination.Auth else RootDestination.Main,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = ::resolveChild
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {
        router.pop()
    }

    val routerState = router.state

    private fun resolveChild(
        mainDestination: RootDestination,
        componentContext: CustomComponentContext,
    ): CustomComponentContext =
        when (mainDestination) {
            RootDestination.Auth -> AuthComponent(componentContext, repositoryProvider, settingsProvider)
            RootDestination.Main -> MainComponent(repositoryProvider, settingsProvider, componentContext)
        }

    fun navigate(destination: RootDestination) {
        router.navigate { listOf(destination) }
    }
}