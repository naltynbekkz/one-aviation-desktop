package main.storage.revision

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface RevisionNavigationComponent : Component {
    val routerState: Value<RouterState<RevisionDestination, Component>>

    fun navigateToScreen(destination: RevisionDestination)
    fun navigateUp()
}