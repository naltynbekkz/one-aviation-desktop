package auth.signIn

import core.Component
import core.NullableInteractor
import network.TokenResponse

interface SignInComponent : Component {

    val signIn: NullableInteractor<TokenResponse, SignInRequest>

}