package main.staff.masters.master

import kotlinx.serialization.Serializable

@Serializable
data class EditPlaneRequest(
    val name: String,
    val mileage: Long,
    val capacity: Int,
    val price: Float,
)