package main.staff.masters.masters

import core.CustomComponentContext
import core.Interactor.Companion.getInteractor
import main.staff.masters.PlanesRepository

class MastersComponent(
    customComponentContext: CustomComponentContext,
    repository: PlanesRepository,
) : CustomComponentContext by customComponentContext {

    val list = getInteractor {
        repository.getPlanes()
    }

}