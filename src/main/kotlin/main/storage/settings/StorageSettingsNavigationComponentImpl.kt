package main.storage.settings

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class StorageSettingsNavigationComponentImpl(
    componentContext: ComponentContext,
) : StorageSettingsNavigationComponent, ComponentContext by componentContext {

    private val router: Router<StorageSettingsDestination, Component> = router(
        initialConfiguration = StorageSettingsDestination.StorageSettings,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                StorageSettingsDestination.StorageSettings -> StorageSettingsComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<StorageSettingsDestination, Component>> = router.state

    override fun navigateToScreen(destination: StorageSettingsDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}