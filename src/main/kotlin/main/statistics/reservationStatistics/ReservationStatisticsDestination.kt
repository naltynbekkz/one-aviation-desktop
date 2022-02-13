package main.statistics.reservationStatistics

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ReservationStatisticsDestination : Parcelable {
    object ReservationStatistics : ReservationStatisticsDestination()
}