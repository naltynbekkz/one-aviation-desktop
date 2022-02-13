package main.finance

import main.MainTab
import main.MainTabGroup

object FinanceTab : MainTabGroup("Finance") {
    object Accounts : MainTab("Accounts")
    object MoneyFlow : MainTab("MoneyFlow")
    object Income : MainTab("Income")
    object Expense : MainTab("Expense")
    object Reports : MainTab("Reports")

    override val destinations = listOf(
        Accounts,
        MoneyFlow,
        Income,
        Expense,
        Reports,
    )
}