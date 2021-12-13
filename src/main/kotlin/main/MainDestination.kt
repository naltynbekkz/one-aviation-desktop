package main

import com.arkivanov.essenty.parcelable.Parcelable

sealed class MainDestination(
    val title: String,
    val screens: List<String> = listOf(),
) : Parcelable {
    object Home : MainDestination("Home")
    object Logs : MainDestination("Logs")

    object Staff : MainDestination(
        title = "Staff",
        screens = listOf(
            "Masters",
            "Admins",
            "OtherStaff",
            "WorkingHours",
            "Salaries",
        )
    )

    object Client : MainDestination(
        title = "Client",
        screens = listOf(
            "Clients",
            "Reservations",
            "Groups",
            "Loyalties",
            "Feedback",
            "Notifications",
            "SmsMailing",
        )
    )

    object Service : MainDestination(
        title = "Service",
        screens = listOf(
            "Services",
            "TechnologyMaps",
            "SalesDeals",
        )
    )

    object Statistics : MainDestination(
        title = "Statistics",
        screens = listOf(
            "ReservationStatistics",
            "Sources",
            "ServiceStatistics",
            "MapStatistics",
            "ClientStatistics",
            "Returnability",
            "Marketplace",
        )
    )

    object Storage : MainDestination(
        title = "Storage",
        screens = listOf(
            "Nomenclature",
            "Sales",
            "TurnOver",
            "Revision",
            "StorageReport",
            "Settings",
        )
    )

    object Finance : MainDestination(
        title = "Finance",
        screens = listOf(
            "Accounts",
            "MoneyFlow",
            "Income",
            "Expense",
            "Reports",
        )
    )

    object Settings : MainDestination("Settings")

    object Help : MainDestination(
        title = "Help",
        screens = listOf(
            "Feedback",
            "Support",
            "Documentation",
            "VideoInstructions",
        )
    )

    object Profile : MainDestination("Profile")

    companion object {
        val screens = listOf(
            Home,
            Logs,
            Staff,
            Client,
            Service,
            Statistics,
            Storage,
            Finance,
            Settings,
            Help,
            Profile,
        )
    }
}