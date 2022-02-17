package main.settings

import core.Component
import kotlinx.coroutines.flow.StateFlow
import main.MainTab

interface SettingsComponent : Component {
    val nightMode: StateFlow<Boolean>

    fun setNightMode(value: Boolean)

    val startupScreen: StateFlow<MainTab>
    fun setStartupScreen(value: MainTab)
}