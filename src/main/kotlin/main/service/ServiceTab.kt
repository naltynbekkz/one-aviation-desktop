package main.service

import main.MainTab
import main.MainTabGroup

object ServiceTab : MainTabGroup("Service") {
    object Services : MainTab("Services")
    object TechnologyMaps : MainTab("TechnologyMaps")
    object SalesDeals : MainTab("SalesDeals")

    override val destinations = listOf(
        Services,
        TechnologyMaps,
        SalesDeals,
    )
}