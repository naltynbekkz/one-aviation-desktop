package main.settings

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component
import main.settings.airplane.AirplaneComponentImpl
import main.settings.billing.BillingComponentImpl
import main.settings.rights.RightsComponentImpl
import main.settings.sms.SmsComponentImpl
import settings.SettingsProvider
import settings.get

class SettingsNavigationComponentImpl(
    componentContext: ComponentContext,
    private val settingsProvider: SettingsProvider,
) : SettingsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<SettingsDestination, Component> = router(
        initialConfiguration = SettingsDestination.Settings,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                SettingsDestination.Settings -> SettingsComponentImpl(componentContext, settingsProvider.get())
                SettingsDestination.Airplane -> AirplaneComponentImpl(componentContext)
                SettingsDestination.Billing -> BillingComponentImpl(componentContext)
                SettingsDestination.Sms -> SmsComponentImpl(componentContext)
                SettingsDestination.Rights -> RightsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<SettingsDestination, Component>> = router.state

    override fun navigateToScreen(destination: SettingsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}