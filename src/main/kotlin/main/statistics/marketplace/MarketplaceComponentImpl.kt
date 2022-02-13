package main.statistics.marketplace

import com.arkivanov.decompose.ComponentContext

class MarketplaceComponentImpl(
    componentContext: ComponentContext,
) : MarketplaceComponent, ComponentContext by componentContext