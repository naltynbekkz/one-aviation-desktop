package main.logs.reservation

import core.Timestamp
import kotlinx.serialization.Serializable
import main.logs.Flight
import main.staff.admins.User

@Serializable
data class Ticket(
    val id: Int,
    val flight: Flight,
    val passenger: Passenger,
    val user: User,
    val timestamp: Timestamp,
)