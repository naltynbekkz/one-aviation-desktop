package settings.impl

import core.CoreSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import settings.BaseSettings
import java.util.prefs.PreferenceChangeListener
import java.util.prefs.Preferences

class CoreSettingsImpl(preferences: Preferences) : BaseSettings(preferences), CoreSettings {

    private val _refreshToken = MutableStateFlow<String?>(get("refreshToken"))
    override val refreshToken = _refreshToken.asStateFlow()
    override fun setRefreshToken(value: String?) = set("refreshToken", value)

    override val listener = PreferenceChangeListener {
        when (it.key) {
            "refreshToken" -> _refreshToken.value = it.newValue
        }
    }

}