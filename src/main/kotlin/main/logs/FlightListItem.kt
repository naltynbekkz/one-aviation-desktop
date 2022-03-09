package main.logs

import kotlinx.serialization.Serializable

@Serializable
data class FlightListItem(
    val flight: Flight,
    val time: Int
)