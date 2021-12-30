package main.settings

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow
import main.MainSettings

class SettingsComponentImpl(
    componentContext: ComponentContext,
    private val mainSettings: MainSettings,
) : SettingsComponent, ComponentContext by componentContext {

    override val nightMode: StateFlow<Boolean> = mainSettings.nightMode

    override fun setNightMode(value: Boolean) {
        mainSettings.setNightMode(value)
    }

}