package auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import auth.forgotPassword.ForgotPasswordComponent
import auth.forgotPassword.ForgotPasswordScreen
import auth.signIn.SignInComponent
import auth.signIn.SignInScreen
import auth.welcome.WelcomeComponent
import auth.welcome.WelcomeScreen
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import core.slideFade

@Composable
fun AuthScreen(authComponent: AuthComponent) {

    val routerState by authComponent.routerState.subscribeAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Children(routerState = routerState, animation = slideFade()) {
            when (val child = it.instance) {
                is WelcomeComponent -> WelcomeScreen(
                    welcomeComponent = child,
                    navigateToSignIn = {
                        authComponent.navigateToScreen(AuthDestination.SignIn)
                    }
                )
                is SignInComponent -> SignInScreen(
                    signInComponent = child,
                    navigateToForgotPassword = {
                        authComponent.navigateToScreen(AuthDestination.ForgotPassword)
                    },
                    navigateUp = {
                        authComponent.navigateUp()
                    },
                )
                is ForgotPasswordComponent -> ForgotPasswordScreen(
                    forgotPasswordComponent = child,
                    navigateUp = {
                        authComponent.navigateUp()
                    }
                )
                else -> error("shouldn't be happening")
            }
        }
    }
}