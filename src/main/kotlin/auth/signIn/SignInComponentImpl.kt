package auth.signIn

import auth.AuthDestination
import auth.AuthRepository
import com.arkivanov.decompose.ComponentContext
import core.CoreSettings
import core.NullableInteractor.Companion.getNullableInteractor

class SignInComponentImpl(
    componentContext: ComponentContext,
    repository: AuthRepository,
    private val coreSettings: CoreSettings,
) : SignInComponent, ComponentContext by componentContext {

    val signIn = getNullableInteractor { request: SignInRequest ->
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