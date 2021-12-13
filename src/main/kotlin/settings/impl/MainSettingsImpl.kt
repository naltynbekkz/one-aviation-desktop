package settings.impl

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import main.MainSettings
import settings.BaseSettings
import java.util.prefs.PreferenceChangeListener
import java.util.prefs.Preferences

class MainSettingsImpl(preferences: Preferences) : BaseSettings(preferences), MainSettings {

    private val _nightMode = MutableStateFlow(preferences.getBoolean("nightMode", false))
    override val nightMode = _nightMode.asStateFlow()

    override fun setNightMode(value: Boolean) {
        preferences.putBoolean("nightMode", value)
    }

    override val listener = PreferenceChangeListener {
        when (it.key) {
            "nightMode" -> _nightMode.value = it.newValue.toBoolean()
        }
    }

}