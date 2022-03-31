package main.settings.settings

import com.arkivanov.decompose.ComponentContext
import core.NavigationResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import main.MainSettings
import main.MainTab

class SettingsComponentImpl(
    componentContext: ComponentContext,
    private val mainSettings: MainSettings,
) : ComponentContext by componentContext {

    val nightMode: StateFlow<Boolean> = mainSettings.nightMode

    fun setNightMode(value: Boolean) {
        mainSettings.setNightMode(value)
    }

    val startupScreen = mainSettings.startupScreen
    fun setStartupScreen(value: MainTab) {
        mainSettings.setStartupScreen(value)
    }

    val navigationResult = MutableStateFlow<NavigationResult?>(null)

}