package main.service.salesDeals

import com.arkivanov.decompose.ComponentContext

class SalesDealsComponentImpl(
    componentContext: ComponentContext,
) : SalesDealsComponent, ComponentContext by componentContext