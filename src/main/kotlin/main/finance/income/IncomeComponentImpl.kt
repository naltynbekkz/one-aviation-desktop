package main.finance.income

import com.arkivanov.decompose.ComponentContext

class IncomeComponentImpl(
    componentContext: ComponentContext,
) : IncomeComponent, ComponentContext by componentContext