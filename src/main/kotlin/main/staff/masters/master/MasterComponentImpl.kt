package main.staff.masters.master

import core.CustomComponentContext
import core.Interactor.Companion.getInteractor
import core.NullableInteractor
import core.NullableInteractor.Companion.getNullableInteractor
import main.staff.admins.AdminRepository
import main.staff.masters.PlanesRepository
import main.staff.masters.addMaster.CreatePlaneRequest
import main.staff.masters.data.Plane

class MasterComponent(
    customComponentContext: CustomComponentContext,
    repository: PlanesRepository,
    private val id: Long,
) : CustomComponentContext by customComponentContext {

    val plane = getInteractor {
        repository.getPlane(id)
    }

    val edit = getNullableInteractor { pair: Pair<Long, EditPlaneRequest> ->
        repository.editPlane(pair.first, pair.second)
    }
}