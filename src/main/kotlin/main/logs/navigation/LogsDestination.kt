package main.logs.navigation

import com.arkivanov.essenty.parcelable.Parcelable

sealed class LogsDestination : Parcelable {
    object Logs : LogsDestination()
    class Reservation(val id: Long) : LogsDestination()
}