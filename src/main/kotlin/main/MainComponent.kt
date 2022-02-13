package main

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface MainComponent : Component {
    val destinations: Value<List<MainTab>>
    val routerState: Value<RouterState<MainTab, Component>>

    fun navigateToScreen(destination: MainTab)
    fun navigateBack()
}