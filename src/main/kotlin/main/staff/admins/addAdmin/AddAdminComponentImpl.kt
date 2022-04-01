package main.staff.admins.addAdmin

import core.CustomComponentContext
import core.NullableInteractor
import core.NullableInteractor.Companion.getNullableInteractor
import main.staff.admins.AdminRepository
import main.staff.admins.User
import main.staff.masters.PlanesRepository

class AddAdminComponent(
    customComponentContext: CustomComponentContext,
    repository: AdminRepository,
) : CustomComponentContext by customComponentContext {

    val addAdmin = getNullableInteractor { request: RegistrationRequest ->
        repository.addAdmin(request)
    }

}