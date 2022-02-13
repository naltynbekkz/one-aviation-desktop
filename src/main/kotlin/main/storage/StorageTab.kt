package main.storage

import main.MainTab
import main.MainTabGroup

object StorageTab : MainTabGroup("Storage") {
    object Nomenclature : MainTab("Nomenclature")
    object Sales : MainTab("Sales")
    object Turnover : MainTab("Turnover")
    object Revision : MainTab("Revision")
    object StorageReport : MainTab("StorageReport")
    object Settings : MainTab("Settings")

    override val destinations = listOf(
        Nomenclature,
        Sales,
        Turnover,
        Revision,
        StorageReport,
        Settings,
    )
}