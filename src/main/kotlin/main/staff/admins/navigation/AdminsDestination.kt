package main.staff.admins.navigation

import com.arkivanov.essenty.parcelable.Parcelable

sealed class AdminsDestination : Parcelable {
    object Admins : AdminsDestination()
    class Admin(val id: Long) : AdminsDestination()
    object AddAdmin : AdminsDestination()
}