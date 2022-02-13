package main.statistics.serviceStatistics

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ServiceStatisticsDestination : Parcelable {
    object ServiceStatistics : ServiceStatisticsDestination()
}