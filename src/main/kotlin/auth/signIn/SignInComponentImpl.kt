package auth.signIn

import auth.AuthRepository
import com.arkivanov.decompose.ComponentContext
import core.CoreSettings
import core.NullableInteractor.Companion.getNullableInteractor
import network.ResponseState

class SignInComponentImpl(
    componentContext: ComponentContext,
    repository: AuthRepository,
    private val coreSettings: CoreSettings,
) : SignInComponent, ComponentContext by componentContext {

    override val signIn = getNullableInteractor { request: SignInRequest ->
        val response = repository.signIn(request)
        if (response is ResponseState.NetworkResponse.Success) {
            coreSettings.setRefreshToken(response.data.uuid)
        }
        response
    }

}