package main.staff.admins.addAdmin

import core.Component
import core.NullableInteractor
import main.staff.admins.User

interface AddAdminComponent : Component {
    val addAdmin: NullableInteractor<User, RegistrationRequest>
}