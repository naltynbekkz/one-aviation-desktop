package main.storage.nomenclature

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import core.Component

class NomenclatureNavigationComponentImpl(
    componentContext: ComponentContext,
) : NomenclatureNavigationComponent, ComponentContext by componentContext {

    private val router: Router<NomenclatureDestination, Component> = router(
        initialConfiguration = NomenclatureDestination.Nomenclature,
        handleBackButton = true,
        childFactory = { destination, componentContext ->
            when (destination) {
                NomenclatureDestination.Nomenclature -> NomenclatureComponentImpl(componentContext)
            }
        }
    )

    override val routerState: Value<RouterState<NomenclatureDestination, Component>> = router.state

    override fun navigateToScreen(destination: NomenclatureDestination) {
        router.navigate { list ->
            list + destination
        }
    }

    override fun navigateUp() {
        router.pop()
    }

}