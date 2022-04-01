package main.settings.settings

import core.CustomComponentContext
import core.NavigationResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import main.MainSettings
import main.MainTab

class SettingsComponent(
    customComponentContext: CustomComponentContext,
    private val mainSettings: MainSettings,
) : CustomComponentContext by customComponentContext {

    val nightMode: StateFlow<Boolean> = mainSettings.nightMode

    fun setNightMode(value: Boolean) {
        mainSettings.setNightMode(value)
    }

    val startupScreen = mainSettings.startupScreen
    fun setStartupScreen(value: MainTab) {
        mainSettings.setStartupScreen(value)
    }

}