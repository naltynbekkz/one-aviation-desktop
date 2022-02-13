package main.statistics.mapStatistics

import com.arkivanov.essenty.parcelable.Parcelable

sealed class MapStatisticsDestination : Parcelable {
    object MapStatistics : MapStatisticsDestination()
}