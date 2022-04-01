package main.settings.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import core.slideFade
import main.settings.actions.ActionsComponent
import main.settings.actions.ActionsScreen
import main.settings.billing.BillingComponent
import main.settings.billing.BillingScreen
import main.settings.deals.DealsComponent
import main.settings.deals.DealsScreen
import main.settings.discounts.DiscountSettingsComponent
import main.settings.discounts.DiscountSettingsScreen
import main.settings.firm.FirmSettingsComponent
import main.settings.firm.FirmSettingsScreen
import main.settings.logs.LogsSettingsComponent
import main.settings.logs.LogsSettingsScreen
import main.settings.permissions.PermissionsSettingsComponent
import main.settings.permissions.PermissionsSettingsScreen
import main.settings.settings.SettingsComponent
import main.settings.settings.SettingsScreen
import main.settings.sms.SmsSettingsComponent
import main.settings.sms.SmsSettingsScreen
import main.settings.sources.SourcesSettingsComponent
import main.settings.sources.SourcesSettingsScreen
import main.settings.workplaces.WorkplacesSettingsComponent
import main.settings.workplaces.WorkplacesSettingsScreen

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun SettingsNavigation(component: SettingsNavigationComponent) {

    val routerState by component.routerState.subscribeAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Children(routerState = routerState, animation = slideFade()) {
            when (val child = it.instance) {
                is SettingsComponent -> SettingsScreen(child, component::navigateToScreen)
                is ActionsComponent -> ActionsScreen(child, component::navigateUp)
                is BillingComponent -> BillingScreen(child, component::navigateUp)
                is DealsComponent -> DealsScreen(child, component::navigateUp)
                is DiscountSettingsComponent -> DiscountSettingsScreen(child, component::navigateUp)
                is FirmSettingsComponent -> FirmSettingsScreen(child, component::navigateUp)
                is LogsSettingsComponent -> LogsSettingsScreen(child, component::navigateUp)
                is PermissionsSettingsComponent -> PermissionsSettingsScreen(child, component::navigateUp)
                is SmsSettingsComponent -> SmsSettingsScreen(child, component::navigateUp)
                is SourcesSettingsComponent -> SourcesSettingsScreen(child, component::navigateUp)
                is WorkplacesSettingsComponent -> WorkplacesSettingsScreen(child, component::navigateUp)
            }
        }
    }
}