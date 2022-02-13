package main.help

import main.MainTab
import main.MainTabGroup

object HelpTab : MainTabGroup("Help") {
    object Feedback : MainTab("Feedback")
    object Support : MainTab("Support")
    object Documentation : MainTab("Documentation")
    object VideoInstructions : MainTab("VideoInstructions")

    override val destinations = listOf(
        Feedback,
        Support,
        Documentation,
        VideoInstructions,
    )
}