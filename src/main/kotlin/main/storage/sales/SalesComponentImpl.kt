package main.storage.sales

import com.arkivanov.decompose.ComponentContext

class SalesComponentImpl(
    componentContext: ComponentContext,
) : SalesComponent, ComponentContext by componentContext