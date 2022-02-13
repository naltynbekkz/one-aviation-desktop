package main.finance.accounts

import com.arkivanov.decompose.ComponentContext

class AccountsComponentImpl(
    componentContext: ComponentContext,
) : AccountsComponent, ComponentContext by componentContext