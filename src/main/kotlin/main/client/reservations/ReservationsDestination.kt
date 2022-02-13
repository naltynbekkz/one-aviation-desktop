package main.client.reservations

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ReservationsDestination : Parcelable {
    object Reservations : ReservationsDestination()
}