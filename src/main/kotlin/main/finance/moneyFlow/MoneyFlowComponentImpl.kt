package main.finance.moneyFlow

import com.arkivanov.decompose.ComponentContext

class MoneyFlowComponentImpl(
    componentContext: ComponentContext,
) : MoneyFlowComponent, ComponentContext by componentContext