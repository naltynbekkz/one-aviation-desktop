package main.finance.moneyFlow

import com.arkivanov.essenty.parcelable.Parcelable

sealed class MoneyFlowDestination : Parcelable {
    object MoneyFlow : MoneyFlowDestination()
}