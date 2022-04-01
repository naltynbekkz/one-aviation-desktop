package main.staff.admins.admin

import core.CustomComponentContext
import core.Interactor.Companion.getInteractor
import core.NullableInteractor.Companion.getNullableInteractor
import main.staff.admins.AdminRepository
import main.staff.admins.addAdmin.RegistrationRequest
import main.staff.masters.master.EditPlaneRequest

class AdminComponent(
    customComponentContext: CustomComponentContext,
    repository: AdminRepository,
    private val id: Long,
) : CustomComponentContext by customComponentContext {

    val admin = getInteractor {
        repository.getAdmin(id)
    }

    val edit = getNullableInteractor { pair: Pair<Long, RegistrationRequest> ->
        repository.editAdmin(pair.first, pair.second)
    }

}