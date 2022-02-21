package main.profile.profile

import com.arkivanov.decompose.ComponentContext
import core.CoreSettings
import core.NullableInteractor.Companion.getNullableInteractor
import main.profile.ProfileRepository
import network.ResponseState

class ProfileComponentImpl(
    componentContext: ComponentContext,
    private val repository: ProfileRepository,
    private val coreSettings: CoreSettings,
) : ProfileComponent, ComponentContext by componentContext {

    override val signOut = getNullableInteractor { _: Unit ->
        val response = repository.signOut()
        if (response is ResponseState.NetworkResponse.Success) {
            coreSettings.setRefreshToken(null)
        }
        response
    }

}