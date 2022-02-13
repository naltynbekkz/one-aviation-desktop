package main.finance.reports

import com.arkivanov.decompose.ComponentContext

class ReportsComponentImpl(
    componentContext: ComponentContext,
) : ReportsComponent, ComponentContext by componentContext