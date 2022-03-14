package main.staff.admins.admin

import core.Component
import core.Interactor
import main.staff.admins.User

interface AdminComponent : Component {
    val admin: Interactor<User>
}