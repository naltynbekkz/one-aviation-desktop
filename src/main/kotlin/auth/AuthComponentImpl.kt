package auth

import auth.forgotPassword.ForgotPasswordComponentImpl
import auth.signIn.SignInComponentImpl
import auth.welcome.WelcomeComponentImpl
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component
import network.RepositoryProvider
import network.get
import settings.SettingsProvider
import settings.get

class AuthComponentImpl(
    componentContext: ComponentContext,
    private val repositoryProvider: RepositoryProvider,
    private val settingsProvider: SettingsProvider,
) : AuthComponent, ComponentContext by componentContext {

    private val router: Router<AuthDestination, Component> = router(
        initialConfiguration = AuthDestination.Welcome,
        handleBackButton = true,
        childFactory = ::resolveChild
    )

    override val routerState: Value<RouterState<AuthDestination, Component>> = router.state

    private fun resolveChild(mainDestination: AuthDestination, componentContext: ComponentContext): Component =
        when (mainDestination) {
            AuthDestination.Welcome -> WelcomeComponentImpl(componentContext)
            AuthDestination.SignIn -> SignInComponentImpl(
                componentContext,
                repositoryProvider.get(),
                settingsProvider.get()
            )
            AuthDestination.ForgotPassword -> ForgotPasswordComponentImpl(componentContext)
        }

    override fun navigateToScreen(authDestination: AuthDestination) {
        router.navigate { list ->
            list.filter { it != authDestination } + authDestination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}