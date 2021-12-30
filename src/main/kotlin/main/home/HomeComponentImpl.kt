package main.home

import com.arkivanov.decompose.ComponentContext

class HomeComponentImpl(
    componentContext: ComponentContext,
) : HomeComponent, ComponentContext by componentContext {

}