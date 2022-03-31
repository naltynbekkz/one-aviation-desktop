package main.settings.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component
import main.settings.actions.ActionsComponentImpl
import main.settings.billing.BillingComponentImpl
import main.settings.deals.DealsComponentImpl
import main.settings.discounts.DiscountSettingsComponentImpl
import main.settings.firm.FirmSettingsComponentImpl
import main.settings.logs.LogsSettingsComponentImpl
import main.settings.permissions.PermissionsSettingsComponentImpl
import main.settings.settings.SettingsComponentImpl
import main.settings.sms.SmsSettingsComponentImpl
import main.settings.sources.SourcesSettingsComponentImpl
import main.settings.workplaces.WorkplacesSettingsComponentImpl
import settings.SettingsProvider
import settings.get

class SettingsNavigationComponentImpl(
    componentContext: ComponentContext,
    private val settingsProvider: SettingsProvider,
) : SettingsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<SettingsDestination, ComponentContext> = router(
        initialConfiguration = SettingsDestination.Settings,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                SettingsDestination.Settings -> SettingsComponentImpl(componentContext, settingsProvider.get())
                SettingsDestination.Actions -> ActionsComponentImpl(componentContext)
                SettingsDestination.Billing -> BillingComponentImpl(componentContext)
                SettingsDestination.Deals -> DealsComponentImpl(componentContext)
                SettingsDestination.DiscountSettings -> DiscountSettingsComponentImpl(componentContext)
                SettingsDestination.FirmSettings -> FirmSettingsComponentImpl(componentContext)
                SettingsDestination.LogsSettings -> LogsSettingsComponentImpl(componentContext)
                SettingsDestination.PermissionsSettings -> PermissionsSettingsComponentImpl(componentContext)
                SettingsDestination.SmsSettings -> SmsSettingsComponentImpl(componentContext)
                SettingsDestination.SourcesSettings -> SourcesSettingsComponentImpl(componentContext)
                SettingsDestination.WorkplacesSettings -> WorkplacesSettingsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<SettingsDestination, ComponentContext>> = router.state

    override fun navigateToScreen(destination: SettingsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
        routerState.value.activeChild.instance.
    }

}