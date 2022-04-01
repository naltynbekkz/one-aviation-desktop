package main.profile.profile

import core.CustomComponentContext
import core.CoreSettings
import core.NullableInteractor.Companion.getNullableInteractor
import main.profile.ProfileRepository
import network.ResponseState

class ProfileComponent(
    customComponentContext: CustomComponentContext,
    private val repository: ProfileRepository,
    private val coreSettings: CoreSettings,
) : CustomComponentContext by customComponentContext {

    val signOut = getNullableInteractor { _: Unit ->
        val response = repository.signOut()
        if (response is ResponseState.NetworkResponse.Success) {
            coreSettings.setRefreshToken(null)
        }
        response
    }

}