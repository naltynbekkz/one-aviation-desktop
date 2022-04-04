package main.settings.airplane

import com.arkivanov.decompose.ComponentContext

class AirplaneComponentImpl(
    componentContext: ComponentContext,
) : AirplaneComponent, ComponentContext by componentContext {

}