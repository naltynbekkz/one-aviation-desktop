package main.finance.expense

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ExpenseDestination : Parcelable {
    object Expense : ExpenseDestination()
}