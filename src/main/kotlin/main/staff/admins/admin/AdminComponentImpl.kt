package main.staff.admins.admin

import com.arkivanov.decompose.ComponentContext
import core.Interactor.Companion.getInteractor
import core.NullableInteractor.Companion.getNullableInteractor
import main.staff.admins.AdminRepository
import main.staff.admins.addAdmin.RegistrationRequest
import main.staff.masters.master.EditPlaneRequest

class AdminComponentImpl(
    componentContext: ComponentContext,
    repository: AdminRepository,
    private val id: Long,
) : AdminComponent, ComponentContext by componentContext {

    override val admin = getInteractor {
        repository.getAdmin(id)
    }

    override val edit = getNullableInteractor { pair: Pair<Long, RegistrationRequest> ->
        repository.editAdmin(pair.first, pair.second)
    }

}