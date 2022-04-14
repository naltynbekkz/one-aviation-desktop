package main.logs.logs

import main.logs.Flight
import main.staff.masters.data.Plane
import kotlinx.serialization.Serializable

@Serializable
data class LogsResponse(
    val plane: Plane,
    val flights: List<Flight>
)