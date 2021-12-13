package main

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface MainComponent: Component {

    val destinations: Value<List<MainDestination>>

    val routerState: Value<RouterState<MainDestination, Component>>

    fun navigateToScreen(mainDestination: MainDestination)
    fun navigateBack()
}