package main.finance.accounts

import com.arkivanov.essenty.parcelable.Parcelable

sealed class AccountsDestination : Parcelable {
    object Accounts : AccountsDestination()
}