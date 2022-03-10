package main.staff.admins.admins

import core.Component
import core.Interactor
import main.staff.admins.User

interface AdminsComponent : Component {
    val admins: Interactor<List<User>>
}