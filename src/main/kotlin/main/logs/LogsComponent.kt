package main.logs

import core.Component
import core.Interactor
import main.staff.masters.data.Plane

interface LogsComponent : Component {
    val flights: Interactor<List<Pair<Plane, List<List<Flight>>>>>
}