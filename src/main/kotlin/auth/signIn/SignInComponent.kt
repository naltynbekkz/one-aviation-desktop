package auth.signIn

import auth.AuthDestination
import core.Component

interface SignInComponent : Component {

    fun navigateToScreen(authDestination: AuthDestination)

    fun setRefreshToken(value: String?)

}