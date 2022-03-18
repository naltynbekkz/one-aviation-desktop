package main.logs.logs

import core.Component
import core.DependentInteractor
import core.NullableInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import main.logs.Flight
import main.logs.FlightStatus
import main.staff.masters.data.Plane
import java.util.*

interface LogsComponent : Component {
    val flights: DependentInteractor<List<Pair<Plane, List<List<Flight>>>>, Calendar>
    fun setDate(calendar: Calendar)
    val date: MutableStateFlow<Calendar>
    val updateFlight: NullableInteractor<Flight, Pair<Long, FlightStatus>>
}