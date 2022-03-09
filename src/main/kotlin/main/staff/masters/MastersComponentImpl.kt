package main.staff.masters

import com.arkivanov.decompose.ComponentContext
import core.Interactor.Companion.getInteractor

class MastersComponentImpl(
    componentContext: ComponentContext,
    repository: PlanesRepository,
) : MastersComponent, ComponentContext by componentContext {

    override val list = getInteractor {
        repository.getPlanes()
    }

}