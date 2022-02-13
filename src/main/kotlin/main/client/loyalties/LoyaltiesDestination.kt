package main.client.loyalties

import com.arkivanov.essenty.parcelable.Parcelable

sealed class LoyaltiesDestination : Parcelable {
    object Loyalties : LoyaltiesDestination()
}