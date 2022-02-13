package main.help.documentation

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface DocumentationNavigationComponent : Component {
    val routerState: Value<RouterState<DocumentationDestination, Component>>

    fun navigateToScreen(destination: DocumentationDestination)
    fun navigateUp()
}