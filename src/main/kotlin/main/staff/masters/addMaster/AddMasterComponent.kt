package main.staff.masters.addMaster

import core.Component
import core.NullableInteractor
import main.staff.masters.data.Plane

interface AddMasterComponent : Component {
    val addMaster: NullableInteractor<Plane, CreatePlaneRequest>
}