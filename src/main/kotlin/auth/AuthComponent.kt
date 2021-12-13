package auth

import core.Component

interface AuthComponent : Component {

    fun navigateToScreen(authDestination: AuthDestination)

    fun setRefreshToken(value: String?)

}