package main.staff.admins.admin

import com.arkivanov.decompose.ComponentContext
import core.Interactor.Companion.getInteractor
import main.staff.admins.AdminRepository

class AdminComponentImpl(
    componentContext: ComponentContext,
    repository: AdminRepository,
    private val id: Long,
) : AdminComponent, ComponentContext by componentContext {

    override val admin = getInteractor {
        repository.getAdmin(id)
    }

}