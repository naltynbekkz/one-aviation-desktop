package settings.impl

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import main.MainSettings
import main.MainTab
import main.allTabs
import main.home.HomeTab
import settings.BaseSettings
import java.util.prefs.PreferenceChangeListener
import java.util.prefs.Preferences

class MainSettingsImpl(preferences: Preferences) : BaseSettings(preferences), MainSettings {

    private val _nightMode = MutableStateFlow(preferences.getBoolean("nightMode", false))
    override val nightMode = _nightMode.asStateFlow()

    override fun setNightMode(value: Boolean) {
        preferences.putBoolean("nightMode", value)
    }

    private val defaultStartupScreenTitle = preferences.get("startupScreen", HomeTab.title)
    private val _startupScreen = MutableStateFlow(allTabs.find { tab ->
        tab.title == defaultStartupScreenTitle
    }!!)
    override val startupScreen = _startupScreen.asStateFlow()

    override fun setStartupScreen(value: MainTab) {
        preferences.put("startupScreen", value.title)
    }

    override val listener = PreferenceChangeListener {
        when (it.key) {
            "nightMode" -> _nightMode.value = it.newValue.toBoolean()
            "startupScreen" -> {
                _startupScreen.value = allTabs.find { tab ->
                    tab.title == it.newValue
                }!!
            }
        }
    }

}