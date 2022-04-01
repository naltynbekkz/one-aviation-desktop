package main.settings.navigation

import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.value.Value
import core.CustomComponentContext
import core.router
import main.settings.actions.ActionsComponent
import main.settings.billing.BillingComponent
import main.settings.deals.DealsComponent
import main.settings.discounts.DiscountSettingsComponent
import main.settings.firm.FirmSettingsComponent
import main.settings.logs.LogsSettingsComponent
import main.settings.permissions.PermissionsSettingsComponent
import main.settings.settings.SettingsComponent
import main.settings.sms.SmsSettingsComponent
import main.settings.sources.SourcesSettingsComponent
import main.settings.workplaces.WorkplacesSettingsComponent
import settings.SettingsProvider
import settings.get

class SettingsNavigationComponent(
    customComponentContext: CustomComponentContext,
    private val settingsProvider: SettingsProvider,
) : CustomComponentContext by customComponentContext {

    private val router: Router<SettingsDestination, CustomComponentContext> = router(
        initialConfiguration = SettingsDestination.Settings,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = { destination, componentContext ->
            when (destination) {
                SettingsDestination.Settings -> SettingsComponent(componentContext, settingsProvider.get())
                SettingsDestination.Actions -> ActionsComponent(componentContext)
                SettingsDestination.Billing -> BillingComponent(componentContext)
                SettingsDestination.Deals -> DealsComponent(componentContext)
                SettingsDestination.DiscountSettings -> DiscountSettingsComponent(componentContext)
                SettingsDestination.FirmSettings -> FirmSettingsComponent(componentContext)
                SettingsDestination.LogsSettings -> LogsSettingsComponent(componentContext)
                SettingsDestination.PermissionsSettings -> PermissionsSettingsComponent(componentContext)
                SettingsDestination.SmsSettings -> SmsSettingsComponent(componentContext)
                SettingsDestination.SourcesSettings -> SourcesSettingsComponent(componentContext)
                SettingsDestination.WorkplacesSettings -> WorkplacesSettingsComponent(componentContext)
            }
        }
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {
        router.pop()
        routerState.value.activeChild.instance.onNavigationResult(args)
    }

    val routerState: Value<RouterState<SettingsDestination, CustomComponentContext>> = router.state

    fun navigateToScreen(destination: SettingsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    fun navigateUp() {
        router.pop()
//        routerState.value.activeChild.instance.onNavigationResult()
    }

}