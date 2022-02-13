package main.storage.nomenclature

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import core.Component

interface NomenclatureNavigationComponent : Component {
    val routerState: Value<RouterState<NomenclatureDestination, Component>>

    fun navigateToScreen(destination: NomenclatureDestination)
    fun navigateUp()
}