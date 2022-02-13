package auth.forgotPassword

import auth.AuthRepository
import com.arkivanov.decompose.ComponentContext
import core.CoreSettings

class ForgotPasswordComponentImpl(
    componentContext: ComponentContext,
) : ForgotPasswordComponent, ComponentContext by componentContext {

//    val signIn = getNullableInteractor { request: SignInRequest ->
//        repository.signIn(request)
//    }

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

//    override fun navigateToScreen(authDestination: AuthDestination) {
////        router.navigate {
////            listOf(authDestination)
////        }
//    }
//
//    override fun setRefreshToken(value: String?) {
//        coreSettings.setRefreshToken(value)
//    }

}