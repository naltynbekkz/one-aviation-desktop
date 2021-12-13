package main.home

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow
import main.MainSettings

class HomeComponentImpl(
    componentContext: ComponentContext,
    private val mainSettings: MainSettings,
) : HomeComponent, ComponentContext by componentContext {

    override val nightMode: StateFlow<Boolean> = mainSettings.nightMode

    override fun setNightMode(value: Boolean) {
        mainSettings.setNightMode(value)
    }

}