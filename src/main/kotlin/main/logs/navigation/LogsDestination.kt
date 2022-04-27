package main.logs.navigation

import com.arkivanov.essenty.parcelable.Parcelable
import java.util.Calendar

sealed class LogsDestination : Parcelable {
    object Logs : LogsDestination()
    class Reservation(val id: Long) : LogsDestination()
    class NewReservation(val calendar: Calendar): LogsDestination()
}