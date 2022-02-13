package main.finance.income

import com.arkivanov.essenty.parcelable.Parcelable

sealed class IncomeDestination : Parcelable {
    object Income : IncomeDestination()
}