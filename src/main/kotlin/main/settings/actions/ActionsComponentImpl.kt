package main.settings.actions


import com.arkivanov.decompose.ComponentContext

class ActionsComponentImpl(
    componentContext: ComponentContext,
) : ActionsComponent, ComponentContext by componentContext