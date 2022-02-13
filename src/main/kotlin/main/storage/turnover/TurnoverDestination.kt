package main.storage.turnover

import com.arkivanov.essenty.parcelable.Parcelable

sealed class TurnoverDestination : Parcelable {
    object Turnover : TurnoverDestination()
}