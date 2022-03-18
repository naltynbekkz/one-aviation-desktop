package main.logs

import kotlinx.serialization.Serializable

@Serializable
data class UpdateFlightRequest(
    val flightStatus: FlightStatus,
)