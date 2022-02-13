package main.logs

import com.arkivanov.decompose.ComponentContext

class LogsComponentImpl(
    componentContext: ComponentContext,
) : LogsComponent, ComponentContext by componentContext