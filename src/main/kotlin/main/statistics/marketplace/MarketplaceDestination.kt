package main.statistics.marketplace

import com.arkivanov.essenty.parcelable.Parcelable

sealed class MarketplaceDestination : Parcelable {
    object Marketplace : MarketplaceDestination()
}