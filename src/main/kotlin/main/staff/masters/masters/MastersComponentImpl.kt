package main.staff.masters.masters

import com.arkivanov.decompose.ComponentContext
import core.Interactor.Companion.getInteractor
import main.staff.masters.PlanesRepository

class MastersComponentImpl(
    componentContext: ComponentContext,
    repository: PlanesRepository,
) : MastersComponent, ComponentContext by componentContext {

    override val list = getInteractor {
        repository.getPlanes()
    }

}