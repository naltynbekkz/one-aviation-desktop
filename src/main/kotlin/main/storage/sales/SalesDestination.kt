package main.storage.sales

import com.arkivanov.essenty.parcelable.Parcelable

sealed class SalesDestination : Parcelable {
    object Sales : SalesDestination()
}