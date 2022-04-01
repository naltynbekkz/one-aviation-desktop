package auth

import auth.forgotPassword.ForgotPasswordComponent
import auth.signIn.SignInComponent
import auth.welcome.WelcomeComponent
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.value.Value
import core.CustomComponentContext
import core.router
import network.RepositoryProvider
import network.get
import settings.SettingsProvider
import settings.get

class AuthComponent(
    customComponentContext: CustomComponentContext,
    private val repositoryProvider: RepositoryProvider,
    private val settingsProvider: SettingsProvider,
) : CustomComponentContext by customComponentContext {

    private val router: Router<AuthDestination, CustomComponentContext> = router(
        initialConfiguration = AuthDestination.Welcome,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = ::resolveChild
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {
        router.pop()
        router.state.value.activeChild.instance
    }

    val routerState: Value<RouterState<AuthDestination, CustomComponentContext>> = router.state

    private fun resolveChild(
        mainDestination: AuthDestination,
        componentContext: CustomComponentContext
    ): CustomComponentContext =
        when (mainDestination) {
            AuthDestination.Welcome -> WelcomeComponent(componentContext)
            AuthDestination.SignIn -> SignInComponent(
                componentContext,
                repositoryProvider.get(),
                settingsProvider.get()
            )
            AuthDestination.ForgotPassword -> ForgotPasswordComponent(componentContext)
        }

    fun navigateToScreen(authDestination: AuthDestination) {
        router.navigate { list ->
            list.filter { it != authDestination } + authDestination
        }
    }

    fun navigateUp() {
        router.pop()
    }

}