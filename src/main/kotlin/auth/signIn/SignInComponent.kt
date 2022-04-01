package auth.signIn

import auth.AuthRepository
import core.CoreSettings
import core.CustomComponentContext
import core.NullableInteractor.Companion.getNullableInteractor
import network.ResponseState

class SignInComponent(
    customComponentContext: CustomComponentContext,
    repository: AuthRepository,
    private val coreSettings: CoreSettings,
) : CustomComponentContext by customComponentContext {

    val signIn = getNullableInteractor { request: SignInRequest ->
        val response = repository.signIn(request)
        if (response is ResponseState.NetworkResponse.Success) {
            coreSettings.setRefreshToken(response.data.uuid)
        }
        response
    }

}