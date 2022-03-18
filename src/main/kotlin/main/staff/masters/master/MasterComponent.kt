package main.staff.masters.master

import core.Component
import core.Interactor
import core.NullableInteractor
import main.staff.admins.User
import main.staff.masters.addMaster.CreatePlaneRequest
import main.staff.masters.data.Plane

interface MasterComponent : Component {
    val plane: Interactor<Plane>
    val edit: NullableInteractor<Plane, Pair<Long, EditPlaneRequest>>
}