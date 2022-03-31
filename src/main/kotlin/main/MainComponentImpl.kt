package main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import core.Component
import development.InDevelopmentComponentImpl
import main.client.ClientsTab
import main.client.clients.ClientsNavigationComponentImpl
import main.client.feedback.ClientFeedbackNavigationComponentImpl
import main.client.groups.GroupsNavigationComponentImpl
import main.client.loyalties.LoyaltiesNavigationComponentImpl
import main.client.notifications.NotificationsNavigationComponentImpl
import main.client.reservations.ReservationsNavigationComponentImpl
import main.client.smsMailing.SmsMailingNavigationComponentImpl
import main.finance.FinanceTab
import main.finance.accounts.AccountsNavigationComponentImpl
import main.finance.expense.ExpenseNavigationComponentImpl
import main.finance.income.IncomeNavigationComponentImpl
import main.finance.moneyFlow.MoneyFlowNavigationComponentImpl
import main.finance.reports.ReportsNavigationComponentImpl
import main.help.HelpTab
import main.help.documentation.DocumentationNavigationComponentImpl
import main.help.support.SupportNavigationComponentImpl
import main.help.videoInstructions.VideoInstructionsNavigationComponentImpl
import main.home.HomeNavigationComponentImpl
import main.home.HomeTab
import main.logs.navigation.LogsNavigationComponentImpl
import main.logs.navigation.LogsTab
import main.profile.navigation.ProfileTab
import main.profile.navigation.ProfileNavigationComponentImpl
import main.service.ServiceTab
import main.service.salesDeals.SalesDealsNavigationComponentImpl
import main.service.services.ServicesNavigationComponentImpl
import main.service.technologyMaps.TechnologyMapsNavigationComponentImpl
import main.settings.navigation.SettingsNavigationComponentImpl
import main.settings.navigation.SettingsTab
import main.staff.StaffTab
import main.staff.admins.navigation.AdminsNavigationComponentImpl
import main.staff.masters.navigation.MastersNavigationComponentImpl
import main.staff.otherStaff.OtherStaffNavigationComponentImpl
import main.staff.salaries.SalariesNavigationComponentImpl
import main.staff.workingHours.WorkingHoursNavigationComponentImpl
import main.statistics.StatisticsTab
import main.statistics.clientStatistics.ClientStatisticsNavigationComponentImpl
import main.statistics.mapStatistics.MapStatisticsNavigationComponentImpl
import main.statistics.marketplace.MarketplaceNavigationComponentImpl
import main.statistics.reservationStatistics.ReservationStatisticsNavigationComponentImpl
import main.statistics.returnability.ReturnabilityNavigationComponentImpl
import main.statistics.serviceStatistics.ServiceStatisticsNavigationComponentImpl
import main.statistics.sources.SourcesNavigationComponentImpl
import main.storage.StorageTab
import main.storage.nomenclature.NomenclatureNavigationComponentImpl
import main.storage.revision.RevisionNavigationComponentImpl
import main.storage.sales.SalesNavigationComponentImpl
import main.storage.settings.StorageSettingsNavigationComponentImpl
import main.storage.storageReport.StorageReportNavigationComponentImpl
import main.storage.turnover.TurnoverNavigationComponentImpl
import network.RepositoryProvider
import settings.SettingsProvider
import settings.get

class MainComponentImpl(
    private val repositoryProvider: RepositoryProvider,
    private val settingsProvider: SettingsProvider,
    componentContext: ComponentContext,
) : MainComponent, ComponentContext by componentContext {

    override val destinations = MutableValue(
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

    private val router: Router<MainTab, Component> = router(
        initialConfiguration = settingsProvider.get<MainSettings>().startupScreen.value,
        handleBackButton = true,
        childFactory = ::resolveChild
    )

    override val routerState: Value<RouterState<MainTab, Component>> = router.state

    private fun resolveChild(destination: MainTab, componentContext: ComponentContext): Component =
        when (destination) {
            HomeTab -> HomeNavigationComponentImpl(componentContext)
            LogsTab -> LogsNavigationComponentImpl(componentContext, repositoryProvider)
            StaffTab.Masters -> MastersNavigationComponentImpl(componentContext, repositoryProvider)
            StaffTab.Admins -> AdminsNavigationComponentImpl(componentContext, repositoryProvider)
            StaffTab.OtherStaff -> OtherStaffNavigationComponentImpl(componentContext)
            StaffTab.WorkingHours -> WorkingHoursNavigationComponentImpl(componentContext)
            StaffTab.Salaries -> SalariesNavigationComponentImpl(componentContext)
            ClientsTab.Clients -> ClientsNavigationComponentImpl(componentContext)
            ClientsTab.Reservations -> ReservationsNavigationComponentImpl(componentContext)
            ClientsTab.Groups -> GroupsNavigationComponentImpl(componentContext)
            ClientsTab.Loyalties -> LoyaltiesNavigationComponentImpl(componentContext)
            ClientsTab.Feedback -> ClientFeedbackNavigationComponentImpl(componentContext)
            ClientsTab.Notifications -> NotificationsNavigationComponentImpl(componentContext)
            ClientsTab.SmsMailing -> SmsMailingNavigationComponentImpl(componentContext)
            ServiceTab.Services -> ServicesNavigationComponentImpl(componentContext)
            ServiceTab.TechnologyMaps -> TechnologyMapsNavigationComponentImpl(componentContext)
            ServiceTab.SalesDeals -> SalesDealsNavigationComponentImpl(componentContext)
            StatisticsTab.ReservationStatistics -> ReservationStatisticsNavigationComponentImpl(componentContext)
            StatisticsTab.Sources -> SourcesNavigationComponentImpl(componentContext)
            StatisticsTab.ServiceStatistics -> ServiceStatisticsNavigationComponentImpl(componentContext)
            StatisticsTab.MapStatistics -> MapStatisticsNavigationComponentImpl(componentContext)
            StatisticsTab.ClientStatistics -> ClientStatisticsNavigationComponentImpl(componentContext)
            StatisticsTab.Returnability -> ReturnabilityNavigationComponentImpl(componentContext)
            StatisticsTab.Marketplace -> MarketplaceNavigationComponentImpl(componentContext)
            StorageTab.Nomenclature -> NomenclatureNavigationComponentImpl(componentContext)
            StorageTab.Sales -> SalesNavigationComponentImpl(componentContext)
            StorageTab.Turnover -> TurnoverNavigationComponentImpl(componentContext)
            StorageTab.Revision -> RevisionNavigationComponentImpl(componentContext)
            StorageTab.StorageReport -> StorageReportNavigationComponentImpl(componentContext)
            StorageTab.Settings -> StorageSettingsNavigationComponentImpl(componentContext)
            FinanceTab.Accounts -> AccountsNavigationComponentImpl(componentContext)
            FinanceTab.MoneyFlow -> MoneyFlowNavigationComponentImpl(componentContext)
            FinanceTab.Income -> IncomeNavigationComponentImpl(componentContext)
            FinanceTab.Expense -> ExpenseNavigationComponentImpl(componentContext)
            FinanceTab.Reports -> ReportsNavigationComponentImpl(componentContext)
            SettingsTab -> SettingsNavigationComponentImpl(componentContext, settingsProvider)
            HelpTab.Feedback -> main.help.feedback.FeedbackNavigationComponentImpl(componentContext)
            HelpTab.Support -> SupportNavigationComponentImpl(componentContext)
            HelpTab.Documentation -> DocumentationNavigationComponentImpl(componentContext)
            HelpTab.VideoInstructions -> VideoInstructionsNavigationComponentImpl(componentContext)
            ProfileTab -> ProfileNavigationComponentImpl(componentContext, settingsProvider, repositoryProvider)
            else -> InDevelopmentComponentImpl(componentContext)
        }

    override fun navigateToScreen(destination: MainTab) {
        router.navigate { list ->
            list.filter { it != destination } + destination
        }
    }

    override fun navigateBack() {
        router.pop()
    }

}