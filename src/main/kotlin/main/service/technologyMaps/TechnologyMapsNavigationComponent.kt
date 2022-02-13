package main.service.technologyMaps

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface TechnologyMapsNavigationComponent : Component {
    val routerState: Value<RouterState<TechnologyMapsDestination, Component>>

    fun navigateToScreen(destination: TechnologyMapsDestination)
    fun navigateUp()
}