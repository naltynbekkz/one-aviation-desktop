package main.staff.masters.masters

import core.Component
import core.Interactor
import main.staff.masters.data.Plane

interface MastersComponent : Component {
    val list: Interactor<List<Plane>>
}