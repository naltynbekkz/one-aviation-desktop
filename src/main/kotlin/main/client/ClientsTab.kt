package main.client

import main.MainTab
import main.MainTabGroup

object ClientsTab : MainTabGroup("Clients") {

    object Clients : MainTab("Clients")
    object Reservations : MainTab("Reservations")
    object Groups : MainTab("Groups")
    object Loyalties : MainTab("Loyalties")
    object Feedback : MainTab("Feedback")
    object Notifications : MainTab("Notifications")
    object SmsMailing : MainTab("SmsMailing")

    override val destinations = listOf(
        Clients,
        Reservations,
        Groups,
        Loyalties,
        Feedback,
        Notifications,
        SmsMailing,
    )
}