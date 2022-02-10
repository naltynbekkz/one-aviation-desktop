package main.profile.profile

import com.arkivanov.decompose.ComponentContext
import core.CoreSettings

class ProfileScreenComponentImpl(
    componentContext: ComponentContext,
    private val coreSettings: CoreSettings,
) : ProfileScreenComponent, ComponentContext by componentContext {

    override val refreshToken = coreSettings.refreshToken

    override fun setRefreshToken(value: String?) {
        coreSettings.setRefreshToken(value)
    }

}