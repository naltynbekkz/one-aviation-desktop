package auth

import com.arkivanov.decompose.ComponentContext
import core.CoreSettings
import core.NullableInteractor
import core.NullableInteractor.Companion.getNullableInteractor
import network.TokenResponse

class AuthComponentImpl(
    componentContext: ComponentContext,
    repository: AuthRepository,
    private val coreSettings: CoreSettings,
) : AuthComponent, ComponentContext by componentContext {

    val signIn: NullableInteractor<TokenResponse, SignInRequest> = getNullableInteractor { request: SignInRequest ->
        repository.signIn(request)
    }

//    private val router: Router<AuthDestination, Any> = router(
//        initialConfiguration = AuthDestination.SignIn,
//        handleBackButton = true,
//        childFactory = ::resolveChild
//    )
//
//    override val routerState: Value<RouterState<AuthDestination, Any>> = router.state
//
//    private fun resolveChild(authDestination: AuthDestination, componentContext: ComponentContext): Any =
//        when (authDestination) {
//            AuthDestination.SignIn -> InDevelopmentComponent(componentContext)
//            else -> InDevelopmentComponent(componentContext)
//        }

    override fun navigateToScreen(authDestination: AuthDestination) {
//        router.navigate {
//            listOf(authDestination)
//        }
    }

    override fun setRefreshToken(value: String?) {
        coreSettings.setRefreshToken(value)
    }

}