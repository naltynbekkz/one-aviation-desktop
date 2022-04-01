package main.staff.masters.addMaster

import core.CustomComponentContext
import core.NullableInteractor.Companion.getNullableInteractor
import main.staff.masters.PlanesRepository
import network.ResponseState

class AddMasterComponent(
    customComponentContext: CustomComponentContext,
    repository: PlanesRepository,
) : CustomComponentContext by customComponentContext {

    val addMaster = getNullableInteractor { request: CreatePlaneRequest ->
        repository.addPlane(request)
    }

}