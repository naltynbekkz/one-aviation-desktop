package main.finance.reports

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ReportsDestination : Parcelable {
    object Reports : ReportsDestination()
}