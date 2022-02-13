package main.statistics.sources

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface SourcesNavigationComponent : Component {
    val routerState: Value<RouterState<SourcesDestination, Component>>

    fun navigateToScreen(destination: SourcesDestination)
    fun navigateUp()
}