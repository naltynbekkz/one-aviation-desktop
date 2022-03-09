package main.staff.masters.addMaster

import kotlinx.serialization.Serializable

@Serializable
data class CreatePlaneRequest(
    val name: String,
    val mileage: Long,
    val capacity: Int,
    val price: Float,
)