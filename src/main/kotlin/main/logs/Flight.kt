package main.logs

import core.Timestamp
import kotlinx.serialization.Serializable
import main.staff.masters.data.Plane

@Serializable
data class Flight(
    val id: Long,
    val plane: Plane,
    val timestamp: Timestamp,
    val departure: Info,
    val arrival: Location,
    val status: FlightStatus,
    val passengerCount: Int,
)