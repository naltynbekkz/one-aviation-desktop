package main.staff.admins

import com.arkivanov.essenty.parcelable.Parcelable

sealed class AdminsDestination : Parcelable {
    object Admins : AdminsDestination()
}