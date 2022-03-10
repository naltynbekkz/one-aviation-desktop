package main.logs.logs

import core.Component
import core.Interactor
import main.logs.Flight
import main.staff.masters.data.Plane

interface LogsComponent : Component {
    val flights: Interactor<List<Pair<Plane, List<List<Flight>>>>>
}