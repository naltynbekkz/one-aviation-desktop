package main.finance.expense

import com.arkivanov.decompose.ComponentContext

class ExpenseComponentImpl(
    componentContext: ComponentContext,
) : ExpenseComponent, ComponentContext by componentContext