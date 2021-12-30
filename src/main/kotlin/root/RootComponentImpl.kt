package root

import auth.AuthComponentImpl
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component
import core.CoreSettings
import main.MainComponentImpl
import network.RepositoryProvider
import network.get
import settings.SettingsProvider
import settings.get

class RootComponentImpl(
    private val repositoryProvider: RepositoryProvider,
    private val settingsProvider: SettingsProvider,
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    override val refreshToken = settingsProvider.get<CoreSettings>().refreshToken

    private val router: Router<RootDestination, Component> = router(
        initialConfiguration = if (refreshToken.value == null) RootDestination.Auth else RootDestination.Main,
        handleBackButton = true,
        childFactory = ::resolveChild
    )
    override val routerState: Value<RouterState<RootDestination, Component>> = router.state

    private fun resolveChild(mainDestination: RootDestination, componentContext: ComponentContext): Component =
        when (mainDestination) {
            RootDestination.Auth -> AuthComponentImpl(
                componentContext,
                repositoryProvider.get(),
                settingsProvider.get()
            )
            RootDestination.Main -> MainComponentImpl(repositoryProvider, settingsProvider, componentContext)
        }

    override fun navigateToAuth() {
        router.navigate { listOf(RootDestination.Auth) }
    }

    override fun navigateToMain() {
        router.navigate { listOf(RootDestination.Main) }
    }

}