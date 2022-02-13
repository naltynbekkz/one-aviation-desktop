package main.statistics.returnability

import com.arkivanov.decompose.ComponentContext

class ReturnabilityComponentImpl(
    componentContext: ComponentContext,
) : ReturnabilityComponent, ComponentContext by componentContext