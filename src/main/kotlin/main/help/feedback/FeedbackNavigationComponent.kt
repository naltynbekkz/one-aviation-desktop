package main.help.feedback

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface FeedbackNavigationComponent : Component {
    val routerState: Value<RouterState<FeedbackDestination, Component>>

    fun navigateToScreen(destination: FeedbackDestination)
    fun navigateUp()
}