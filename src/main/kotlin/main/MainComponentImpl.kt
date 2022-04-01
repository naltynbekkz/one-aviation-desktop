package main

import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.value.MutableValue
import core.Component
import core.CustomComponentContext
import core.router
import main.client.ClientsTab
import main.client.clients.ClientsNavigationComponent
import main.client.feedback.ClientFeedbackNavigationComponent
import main.client.groups.GroupsNavigationComponent
import main.client.loyalties.LoyaltiesNavigationComponent
import main.client.notifications.NotificationsNavigationComponent
import main.client.reservations.ReservationsNavigationComponent
import main.client.smsMailing.SmsMailingNavigationComponent
import main.finance.FinanceTab
import main.finance.accounts.AccountsNavigationComponent
import main.finance.expense.ExpenseNavigationComponent
import main.finance.income.IncomeNavigationComponent
import main.finance.moneyFlow.MoneyFlowNavigationComponent
import main.finance.reports.ReportsNavigationComponent
import main.help.HelpTab
import main.help.documentation.DocumentationNavigationComponent
import main.help.support.SupportNavigationComponent
import main.help.videoInstructions.VideoInstructionsNavigationComponent
import main.home.HomeNavigationComponent
import main.home.HomeTab
import main.logs.navigation.LogsNavigationComponent
import main.logs.navigation.LogsTab
import main.profile.navigation.ProfileNavigationComponent
import main.profile.navigation.ProfileTab
import main.service.ServiceTab
import main.service.salesDeals.SalesDealsNavigationComponent
import main.service.services.ServicesNavigationComponent
import main.service.technologyMaps.TechnologyMapsNavigationComponent
import main.settings.navigation.SettingsNavigationComponent
import main.settings.navigation.SettingsTab
import main.staff.StaffTab
import main.staff.admins.navigation.AdminsNavigationComponent
import main.staff.masters.navigation.MastersNavigationComponent
import main.staff.otherStaff.OtherStaffNavigationComponent
import main.staff.salaries.SalariesNavigationComponent
import main.staff.workingHours.WorkingHoursNavigationComponent
import main.statistics.StatisticsTab
import main.statistics.clientStatistics.ClientStatisticsNavigationComponent
import main.statistics.mapStatistics.MapStatisticsNavigationComponent
import main.statistics.marketplace.MarketplaceNavigationComponent
import main.statistics.reservationStatistics.ReservationStatisticsNavigationComponent
import main.statistics.returnability.ReturnabilityNavigationComponent
import main.statistics.serviceStatistics.ServiceStatisticsNavigationComponent
import main.statistics.sources.SourcesNavigationComponent
import main.storage.StorageTab
import main.storage.nomenclature.NomenclatureNavigationComponent
import main.storage.revision.RevisionNavigationComponent
import main.storage.sales.SalesNavigationComponent
import main.storage.settings.StorageSettingsNavigationComponent
import main.storage.storageReport.StorageReportNavigationComponent
import main.storage.turnover.TurnoverNavigationComponent
import network.RepositoryProvider
import settings.SettingsProvider
import settings.get

class MainComponent(
    private val repositoryProvider: RepositoryProvider,
    private val settingsProvider: SettingsProvider,
    customComponentContext: CustomComponentContext,
) : CustomComponentContext by customComponentContext {

    val destinations = MutableValue(
        listOf(
            HomeTab,
            LogsTab,
            StaffTab,
            ClientsTab,
            ServiceTab,
            StatisticsTab,
            StorageTab,
            FinanceTab,
            SettingsTab,
            HelpTab,
            ProfileTab,
        )
    )

    private val router: Router<MainTab, CustomComponentContext> = router(
        initialConfiguration = settingsProvider.get<MainSettings>().startupScreen.value,
        handleBackButton = true,
        setNavigationResultAndNavigateUp = ::handleChildNavigationResult,
        childFactory = ::resolveChild,
    )

    private fun handleChildNavigationResult(args: Map<String, Any>) {

    }

    val routerState = router.state

    private fun resolveChild(destination: MainTab, componentContext: CustomComponentContext): CustomComponentContext =
        when (destination) {
            HomeTab -> HomeNavigationComponent(componentContext)
            LogsTab -> LogsNavigationComponent(componentContext, repositoryProvider)
            StaffTab.Masters -> MastersNavigationComponent(componentContext, repositoryProvider)
            StaffTab.Admins -> AdminsNavigationComponent(componentContext, repositoryProvider)
            StaffTab.OtherStaff -> OtherStaffNavigationComponent(componentContext)
            StaffTab.WorkingHours -> WorkingHoursNavigationComponent(componentContext)
            StaffTab.Salaries -> SalariesNavigationComponent(componentContext)
            ClientsTab.Clients -> ClientsNavigationComponent(componentContext)
            ClientsTab.Reservations -> ReservationsNavigationComponent(componentContext)
            ClientsTab.Groups -> GroupsNavigationComponent(componentContext)
            ClientsTab.Loyalties -> LoyaltiesNavigationComponent(componentContext)
            ClientsTab.Feedback -> ClientFeedbackNavigationComponent(componentContext)
            ClientsTab.Notifications -> NotificationsNavigationComponent(componentContext)
            ClientsTab.SmsMailing -> SmsMailingNavigationComponent(componentContext)
            ServiceTab.Services -> ServicesNavigationComponent(componentContext)
            ServiceTab.TechnologyMaps -> TechnologyMapsNavigationComponent(componentContext)
            ServiceTab.SalesDeals -> SalesDealsNavigationComponent(componentContext)
            StatisticsTab.ReservationStatistics -> ReservationStatisticsNavigationComponent(componentContext)
            StatisticsTab.Sources -> SourcesNavigationComponent(componentContext)
            StatisticsTab.ServiceStatistics -> ServiceStatisticsNavigationComponent(componentContext)
            StatisticsTab.MapStatistics -> MapStatisticsNavigationComponent(componentContext)
            StatisticsTab.ClientStatistics -> ClientStatisticsNavigationComponent(componentContext)
            StatisticsTab.Returnability -> ReturnabilityNavigationComponent(componentContext)
            StatisticsTab.Marketplace -> MarketplaceNavigationComponent(componentContext)
            StorageTab.Nomenclature -> NomenclatureNavigationComponent(componentContext)
            StorageTab.Sales -> SalesNavigationComponent(componentContext)
            StorageTab.Turnover -> TurnoverNavigationComponent(componentContext)
            StorageTab.Revision -> RevisionNavigationComponent(componentContext)
            StorageTab.StorageReport -> StorageReportNavigationComponent(componentContext)
            StorageTab.Settings -> StorageSettingsNavigationComponent(componentContext)
            FinanceTab.Accounts -> AccountsNavigationComponent(componentContext)
            FinanceTab.MoneyFlow -> MoneyFlowNavigationComponent(componentContext)
            FinanceTab.Income -> IncomeNavigationComponent(componentContext)
            FinanceTab.Expense -> ExpenseNavigationComponent(componentContext)
            FinanceTab.Reports -> ReportsNavigationComponent(componentContext)
            SettingsTab -> SettingsNavigationComponent(componentContext, settingsProvider)
            HelpTab.Feedback -> main.help.feedback.FeedbackNavigationComponent(componentContext)
            HelpTab.Support -> SupportNavigationComponent(componentContext)
            HelpTab.Documentation -> DocumentationNavigationComponent(componentContext)
            HelpTab.VideoInstructions -> VideoInstructionsNavigationComponent(componentContext)
            ProfileTab -> ProfileNavigationComponent(componentContext, settingsProvider, repositoryProvider)
            else -> error("no such main tab")
        }

    fun navigateToScreen(destination: MainTab) {
        router.navigate { list ->
            list.filter { it != destination } + destination
        }
    }

    fun navigateBack() {
        router.pop()
    }

}