package main.logs

import com.arkivanov.essenty.parcelable.Parcelable

sealed class LogsDestination : Parcelable {
    object Logs : LogsDestination()
}