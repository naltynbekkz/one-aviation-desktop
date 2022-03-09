package main.staff.masters.data

import core.Timestamp
import kotlinx.serialization.Serializable

@Serializable
class Plane(
    val id: Long,
    val name: String,
    val mileage: Long,
    val capacity: Int,
    val price: Float,
    var timestamp: Timestamp,
)