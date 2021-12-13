package settings

import settings.impl.CoreSettingsImpl
import settings.impl.MainSettingsImpl
import java.util.prefs.Preferences

class SettingsProviderImpl(
    private val preferences: Preferences
) : SettingsProvider {

    override val settings = listOf(
        CoreSettingsImpl(preferences),
        MainSettingsImpl(preferences),
    )

    override fun start() {
        settings.forEach {
            preferences.addPreferenceChangeListener(it.listener)
        }
    }

    override fun stop() {
        settings.forEach {
            preferences.removePreferenceChangeListener(it.listener)
        }
    }
}