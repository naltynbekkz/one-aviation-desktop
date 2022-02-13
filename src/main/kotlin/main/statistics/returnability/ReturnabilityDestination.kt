package main.statistics.returnability

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ReturnabilityDestination : Parcelable {
    object Returnability : ReturnabilityDestination()
}