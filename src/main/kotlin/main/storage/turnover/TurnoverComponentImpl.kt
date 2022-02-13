package main.storage.turnover

import com.arkivanov.decompose.ComponentContext

class TurnoverComponentImpl(
    componentContext: ComponentContext,
) : TurnoverComponent, ComponentContext by componentContext