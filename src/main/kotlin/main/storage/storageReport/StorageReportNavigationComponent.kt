package main.storage.storageReport

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface StorageReportNavigationComponent : Component {
    val routerState: Value<RouterState<StorageReportDestination, Component>>

    fun navigateToScreen(destination: StorageReportDestination)
    fun navigateUp()
}