package main.staff.masters.addMaster

import com.arkivanov.decompose.ComponentContext
import core.NullableInteractor.Companion.getNullableInteractor
import main.staff.masters.PlanesRepository
import network.ResponseState

class AddMasterComponentImpl(
    componentContext: ComponentContext,
    repository: PlanesRepository,
) : AddMasterComponent, ComponentContext by componentContext {

    override val addMaster = getNullableInteractor { request: CreatePlaneRequest ->
        repository.addPlane(request)
    }

}