package main.home

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface HomeNavigationComponent : Component {
    val routerState: Value<RouterState<HomeDestination, Component>>

    fun navigateToScreen(destination: HomeDestination)
    fun navigateUp()
}