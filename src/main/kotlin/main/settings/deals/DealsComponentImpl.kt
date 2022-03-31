package main.settings.deals

import com.arkivanov.decompose.ComponentContext

class DealsComponentImpl(
    componentContext: ComponentContext,
) : DealsComponent, ComponentContext by componentContext