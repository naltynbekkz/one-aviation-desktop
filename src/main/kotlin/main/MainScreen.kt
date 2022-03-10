package main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.animation.child.crossfadeScale
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import core.hover
import development.InDevelopment
import development.InDevelopmentComponent
import main.client.clients.ClientsNavigation
import main.client.clients.ClientsNavigationComponent
import main.client.feedback.ClientFeedbackNavigation
import main.client.feedback.ClientFeedbackNavigationComponent
import main.client.groups.GroupsNavigation
import main.client.groups.GroupsNavigationComponent
import main.client.loyalties.LoyaltiesNavigation
import main.client.loyalties.LoyaltiesNavigationComponent
import main.client.notifications.NotificationsNavigation
import main.client.notifications.NotificationsNavigationComponent
import main.client.reservations.ReservationsNavigation
import main.client.reservations.ReservationsNavigationComponent
import main.client.smsMailing.SmsMailingNavigation
import main.client.smsMailing.SmsMailingNavigationComponent
import main.finance.accounts.AccountsNavigation
import main.finance.accounts.AccountsNavigationComponent
import main.finance.expense.ExpenseNavigation
import main.finance.expense.ExpenseNavigationComponent
import main.finance.income.IncomeNavigation
import main.finance.income.IncomeNavigationComponent
import main.finance.moneyFlow.MoneyFlowNavigation
import main.finance.moneyFlow.MoneyFlowNavigationComponent
import main.finance.reports.ReportsNavigation
import main.finance.reports.ReportsNavigationComponent
import main.help.documentation.DocumentationNavigation
import main.help.documentation.DocumentationNavigationComponent
import main.help.feedback.FeedbackNavigation
import main.help.feedback.FeedbackNavigationComponent
import main.help.support.SupportNavigation
import main.help.support.SupportNavigationComponent
import main.help.videoInstructions.VideoInstructionsNavigation
import main.help.videoInstructions.VideoInstructionsNavigationComponent
import main.home.HomeNavigation
import main.home.HomeNavigationComponent
import main.logs.navigation.LogsNavigation
import main.logs.navigation.LogsNavigationComponent
import main.profile.navigation.ProfileNavigation
import main.profile.navigation.ProfileNavigationComponent
import main.service.salesDeals.SalesDealsNavigation
import main.service.salesDeals.SalesDealsNavigationComponent
import main.service.services.ServicesNavigation
import main.service.services.ServicesNavigationComponent
import main.service.technologyMaps.TechnologyMapsNavigation
import main.service.technologyMaps.TechnologyMapsNavigationComponent
import main.settings.SettingsNavigation
import main.settings.SettingsNavigationComponent
import main.staff.admins.navigation.AdminsNavigation
import main.staff.admins.navigation.AdminsNavigationComponent
import main.staff.masters.navigation.MastersNavigation
import main.staff.masters.navigation.MastersNavigationComponent
import main.staff.otherStaff.OtherStaffNavigation
import main.staff.otherStaff.OtherStaffNavigationComponent
import main.staff.salaries.SalariesNavigation
import main.staff.salaries.SalariesNavigationComponent
import main.staff.workingHours.WorkingHoursNavigation
import main.staff.workingHours.WorkingHoursNavigationComponent
import main.statistics.clientStatistics.ClientStatisticsNavigation
import main.statistics.clientStatistics.ClientStatisticsNavigationComponent
import main.statistics.mapStatistics.MapStatisticsNavigation
import main.statistics.mapStatistics.MapStatisticsNavigationComponent
import main.statistics.marketplace.MarketplaceNavigation
import main.statistics.marketplace.MarketplaceNavigationComponent
import main.statistics.reservationStatistics.ReservationStatisticsNavigation
import main.statistics.reservationStatistics.ReservationStatisticsNavigationComponent
import main.statistics.returnability.ReturnabilityNavigation
import main.statistics.returnability.ReturnabilityNavigationComponent
import main.statistics.serviceStatistics.ServiceStatisticsNavigation
import main.statistics.serviceStatistics.ServiceStatisticsNavigationComponent
import main.statistics.sources.SourcesNavigation
import main.statistics.sources.SourcesNavigationComponent
import main.storage.nomenclature.NomenclatureNavigation
import main.storage.nomenclature.NomenclatureNavigationComponent
import main.storage.revision.RevisionNavigation
import main.storage.revision.RevisionNavigationComponent
import main.storage.sales.SalesNavigation
import main.storage.sales.SalesNavigationComponent
import main.storage.settings.StorageSettingsNavigation
import main.storage.settings.StorageSettingsNavigationComponent
import main.storage.storageReport.StorageReportNavigation
import main.storage.storageReport.StorageReportNavigationComponent
import main.storage.turnover.TurnoverNavigation
import main.storage.turnover.TurnoverNavigationComponent
import theme.gray600

@OptIn(ExperimentalDecomposeApi::class, androidx.compose.ui.ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(mainComponent: MainComponent) {
    val routerState by mainComponent.routerState.subscribeAsState()
    val destinations by mainComponent.destinations.subscribeAsState()

    val selectedDestination = routerState.activeChild.configuration

    Row {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.primary.copy(alpha = 0.12f))
                .fillMaxHeight()
                .width(240.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(Modifier.padding(vertical = 16.dp))
            for (destination in destinations) {

                var isExpanded by remember { mutableStateOf(false) }

                val backgroundAlpha = remember(isExpanded) {
                    if (isExpanded) 0.06f else 0f
                }

                Column(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colors.primary.copy(alpha = backgroundAlpha),
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .fillMaxWidth()
                            .height(56.dp)
                            .hover()
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                enabled = destination != selectedDestination,
                            ) {
                                if (destination is MainTabGroup) {
                                    isExpanded = !isExpanded
                                } else {
                                    mainComponent.navigateToScreen(destination)
                                }
                            },
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = destination.title,
                            modifier = Modifier.padding(horizontal = 16.dp),
                            style = MaterialTheme.typography.subtitle1,
                        )
                    }
                    if (destination is MainTabGroup) {
                        AnimatedVisibility(isExpanded) {
                            Column {
                                destination.destinations.forEach {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .hover()
                                            .clickable(
                                                interactionSource = remember { MutableInteractionSource() },
                                                indication = null,
                                                enabled = it != selectedDestination,
                                            ) {
                                                mainComponent.navigateToScreen(it)
                                            }
                                            .padding(16.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    ) {
                                        Box(Modifier.size(16.dp).background(MaterialTheme.colors.gray600))
                                        Text(
                                            text = it.title,
                                            modifier = Modifier
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
        }

        Box(modifier = Modifier.weight(1f)) {
            Children(routerState = routerState, animation = crossfadeScale()) {
                when (val component = it.instance) {
                    is HomeNavigationComponent -> HomeNavigation(component)
                    is LogsNavigationComponent -> LogsNavigation(component)
                    is MastersNavigationComponent -> MastersNavigation(component)
                    is AdminsNavigationComponent -> AdminsNavigation(component)
                    is OtherStaffNavigationComponent -> OtherStaffNavigation(component)
                    is WorkingHoursNavigationComponent -> WorkingHoursNavigation(component)
                    is SalariesNavigationComponent -> SalariesNavigation(component)
                    is ClientsNavigationComponent -> ClientsNavigation(component)
                    is ReservationsNavigationComponent -> ReservationsNavigation(component)
                    is GroupsNavigationComponent -> GroupsNavigation(component)
                    is LoyaltiesNavigationComponent -> LoyaltiesNavigation(component)
                    is ClientFeedbackNavigationComponent -> ClientFeedbackNavigation(component)
                    is NotificationsNavigationComponent -> NotificationsNavigation(component)
                    is SmsMailingNavigationComponent -> SmsMailingNavigation(component)
                    is ServicesNavigationComponent -> ServicesNavigation(component)
                    is TechnologyMapsNavigationComponent -> TechnologyMapsNavigation(component)
                    is SalesDealsNavigationComponent -> SalesDealsNavigation(component)
                    is ReservationStatisticsNavigationComponent -> ReservationStatisticsNavigation(component)
                    is SourcesNavigationComponent -> SourcesNavigation(component)
                    is ServiceStatisticsNavigationComponent -> ServiceStatisticsNavigation(component)
                    is MapStatisticsNavigationComponent -> MapStatisticsNavigation(component)
                    is ClientStatisticsNavigationComponent -> ClientStatisticsNavigation(component)
                    is ReturnabilityNavigationComponent -> ReturnabilityNavigation(component)
                    is MarketplaceNavigationComponent -> MarketplaceNavigation(component)
                    is NomenclatureNavigationComponent -> NomenclatureNavigation(component)
                    is SalesNavigationComponent -> SalesNavigation(component)
                    is TurnoverNavigationComponent -> TurnoverNavigation(component)
                    is RevisionNavigationComponent -> RevisionNavigation(component)
                    is StorageReportNavigationComponent -> StorageReportNavigation(component)
                    is StorageSettingsNavigationComponent -> StorageSettingsNavigation(component)
                    is AccountsNavigationComponent -> AccountsNavigation(component)
                    is MoneyFlowNavigationComponent -> MoneyFlowNavigation(component)
                    is IncomeNavigationComponent -> IncomeNavigation(component)
                    is ExpenseNavigationComponent -> ExpenseNavigation(component)
                    is ReportsNavigationComponent -> ReportsNavigation(component)
                    is SettingsNavigationComponent -> SettingsNavigation(component)
                    is FeedbackNavigationComponent -> FeedbackNavigation(component)
                    is SupportNavigationComponent -> SupportNavigation(component)
                    is DocumentationNavigationComponent -> DocumentationNavigation(component)
                    is VideoInstructionsNavigationComponent -> VideoInstructionsNavigation(component)
                    is ProfileNavigationComponent -> ProfileNavigation(component)
                    is InDevelopmentComponent -> InDevelopment(component)
                }
            }
        }
    }
}