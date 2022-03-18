package main.staff.masters.master

import com.arkivanov.decompose.ComponentContext
import core.Interactor.Companion.getInteractor
import core.NullableInteractor
import core.NullableInteractor.Companion.getNullableInteractor
import main.staff.admins.AdminRepository
import main.staff.masters.PlanesRepository
import main.staff.masters.addMaster.CreatePlaneRequest
import main.staff.masters.data.Plane

class MasterComponentImpl(
    componentContext: ComponentContext,
    repository: PlanesRepository,
    private val id: Long,
) : MasterComponent, ComponentContext by componentContext {

    override val plane = getInteractor {
        repository.getPlane(id)
    }

    override val edit = getNullableInteractor { pair: Pair<Long, EditPlaneRequest> ->
        repository.editPlane(pair.first, pair.second)
    }
}