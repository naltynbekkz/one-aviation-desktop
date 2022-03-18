package main.staff.admins.admin

import core.Component
import core.Interactor
import core.NullableInteractor
import main.staff.admins.User
import main.staff.admins.addAdmin.RegistrationRequest
import main.staff.masters.data.Plane
import main.staff.masters.master.EditPlaneRequest

interface AdminComponent : Component {
    val admin: Interactor<User>
    val edit: NullableInteractor<User, Pair<Long, RegistrationRequest>>
}