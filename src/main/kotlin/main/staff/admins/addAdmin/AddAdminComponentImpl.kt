package main.staff.admins.addAdmin

import com.arkivanov.decompose.ComponentContext
import core.NullableInteractor
import core.NullableInteractor.Companion.getNullableInteractor
import main.staff.admins.AdminRepository
import main.staff.admins.User
import main.staff.masters.PlanesRepository

class AddAdminComponentImpl(
    componentContext: ComponentContext,
    repository: AdminRepository,
) : AddAdminComponent, ComponentContext by componentContext {

    override val addAdmin = getNullableInteractor { request: RegistrationRequest ->
        repository.addAdmin(request)
    }

}