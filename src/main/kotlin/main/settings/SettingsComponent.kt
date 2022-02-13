package main.settings

import core.Component
import kotlinx.coroutines.flow.StateFlow

interface SettingsComponent : Component {
    val nightMode: StateFlow<Boolean>

    fun setNightMode(value: Boolean)
}