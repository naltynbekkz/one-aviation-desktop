package main.staff

import main.MainTab
import main.MainTabGroup

object StaffTab : MainTabGroup("Staff") {
    object Masters : MainTab("Planes")
    object Admins : MainTab("Admins")
    object OtherStaff : MainTab("OtherStaff")
    object WorkingHours : MainTab("WorkingHours")
    object Salaries : MainTab("Salaries")

    override val destinations = listOf(
        Masters,
        Admins,
        OtherStaff,
        WorkingHours,
        Salaries,
    )
}