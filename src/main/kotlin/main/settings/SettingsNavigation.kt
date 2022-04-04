package main.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import core.slideFade
import main.settings.airplane.AirplaneComponent
import main.settings.airplane.AirplaneScreen
import main.settings.billing.BillingComponent
import main.settings.billing.BillingScreen
import main.settings.rights.RightsComponent
import main.settings.rights.RightsScreen
import main.settings.sms.SmsComponent
import main.settings.sms.SmsScreen

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun SettingsNavigation(component: SettingsNavigationComponent) {

    val routerState by component.routerState.subscribeAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Children(routerState = routerState, animation = slideFade()) {
            when (val child = it.instance) {
                is SettingsComponent -> SettingsScreen(child,
                    navigateToAirplane = {
                        component.navigateToScreen(SettingsDestination.Airplane)
                    },
                    navigateToBilling = {
                        component.navigateToScreen(SettingsDestination.Billing)
                    },
                    navigateToSms = {
                        component.navigateToScreen(SettingsDestination.Sms)
                    },
                    navigateToRights = {
                        component.navigateToScreen(SettingsDestination.Rights)
                    }
                )
                is AirplaneComponent -> AirplaneScreen(child) {
                    component.navigateUp()
                }
                is BillingComponent -> BillingScreen(child) {
                    component.navigateUp()
                }
                is SmsComponent -> SmsScreen(child) {
                    component.navigateUp()
                }
                is RightsComponent -> RightsScreen(child) {
                    component.navigateUp()
                }
            }
        }
    }
}