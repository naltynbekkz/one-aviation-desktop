package main

import com.arkivanov.essenty.parcelable.Parcelable
import main.client.ClientsTab
import main.finance.FinanceTab
import main.help.HelpTab
import main.home.HomeTab
import main.logs.LogsTab
import main.profile.ProfileTab
import main.service.ServiceTab
import main.settings.SettingsTab
import main.staff.StaffTab
import main.statistics.StatisticsTab
import main.storage.StorageTab

abstract class MainTab(val title: String) : Parcelable

val allTabs = listOf(
    HomeTab,
    LogsTab,
    StaffTab.Masters,
    StaffTab.Admins,
    StaffTab.OtherStaff,
    StaffTab.WorkingHours,
    StaffTab.Salaries,
    ClientsTab.Clients,
    ClientsTab.Reservations,
    ClientsTab.Groups,
    ClientsTab.Loyalties,
    ClientsTab.Feedback,
    ClientsTab.Notifications,
    ClientsTab.SmsMailing,
    ServiceTab.Services,
    ServiceTab.TechnologyMaps,
    ServiceTab.SalesDeals,
    StatisticsTab.ReservationStatistics,
    StatisticsTab.Sources,
    StatisticsTab.ServiceStatistics,
    StatisticsTab.MapStatistics,
    StatisticsTab.ClientStatistics,
    StatisticsTab.Returnability,
    StatisticsTab.Marketplace,
    StorageTab.Nomenclature,
    StorageTab.Sales,
    StorageTab.Turnover,
    StorageTab.Revision,
    StorageTab.StorageReport,
    StorageTab.Settings,
    FinanceTab.Accounts,
    FinanceTab.MoneyFlow,
    FinanceTab.Income,
    FinanceTab.Expense,
    FinanceTab.Reports,
    SettingsTab,
    HelpTab.Feedback,
    HelpTab.Support,
    HelpTab.Documentation,
    HelpTab.VideoInstructions,
    ProfileTab,
)

abstract class MainTabGroup(title: String) : MainTab(title) {
    abstract val destinations: List<MainTab>
}