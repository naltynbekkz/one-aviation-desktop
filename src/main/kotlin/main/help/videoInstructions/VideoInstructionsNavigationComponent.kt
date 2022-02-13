package main.help.videoInstructions

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface VideoInstructionsNavigationComponent : Component {
    val routerState: Value<RouterState<VideoInstructionsDestination, Component>>

    fun navigateToScreen(destination: VideoInstructionsDestination)
    fun navigateUp()
}