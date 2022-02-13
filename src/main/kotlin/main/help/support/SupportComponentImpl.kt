package main.help.support

import com.arkivanov.decompose.ComponentContext

class SupportComponentImpl(
    componentContext: ComponentContext,
) : SupportComponent, ComponentContext by componentContext