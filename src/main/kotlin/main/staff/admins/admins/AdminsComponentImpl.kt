package main.staff.admins.admins

import core.CustomComponentContext
import core.Interactor.Companion.getInteractor
import main.staff.admins.AdminRepository

class AdminsComponent(
    customComponentContext: CustomComponentContext,
    repository: AdminRepository,
) : CustomComponentContext by customComponentContext {

    val admins = getInteractor {
        repository.getAdmins()
    }

}