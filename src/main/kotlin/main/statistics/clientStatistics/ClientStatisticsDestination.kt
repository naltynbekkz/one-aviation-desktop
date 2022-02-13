package main.statistics.clientStatistics

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ClientStatisticsDestination : Parcelable {
    object ClientStatistics : ClientStatisticsDestination()
}