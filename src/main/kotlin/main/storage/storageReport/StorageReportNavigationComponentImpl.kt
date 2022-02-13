package main.storage.storageReport

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class StorageReportNavigationComponentImpl(
    componentContext: ComponentContext,
) : StorageReportNavigationComponent, ComponentContext by componentContext {

    private val router: Router<StorageReportDestination, Component> = router(
        initialConfiguration = StorageReportDestination.StorageReport,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                StorageReportDestination.StorageReport -> StorageReportComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<StorageReportDestination, Component>> = router.state

    override fun navigateToScreen(destination: StorageReportDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}