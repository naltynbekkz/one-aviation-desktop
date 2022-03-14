package main.staff.admins.admins

import com.arkivanov.decompose.ComponentContext
import core.Interactor.Companion.getInteractor
import main.staff.admins.AdminRepository

class AdminsComponentImpl(
    componentContext: ComponentContext,
    repository: AdminRepository,
) : AdminsComponent, ComponentContext by componentContext {

    override val admins = getInteractor {
        repository.getAdmins()
    }

}