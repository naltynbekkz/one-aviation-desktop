package main.help.videoInstructions

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class VideoInstructionsNavigationComponentImpl(
    componentContext: ComponentContext,
) : VideoInstructionsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<VideoInstructionsDestination, Component> = router(
        initialConfiguration = VideoInstructionsDestination.VideoInstructions,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                VideoInstructionsDestination.VideoInstructions -> VideoInstructionsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<VideoInstructionsDestination, Component>> = router.state

    override fun navigateToScreen(destination: VideoInstructionsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}