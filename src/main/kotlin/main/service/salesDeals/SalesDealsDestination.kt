package main.service.salesDeals

import com.arkivanov.essenty.parcelable.Parcelable

sealed class SalesDealsDestination : Parcelable {
    object SalesDeals : SalesDealsDestination()
}