package main.logs.reservation

import kotlinx.serialization.Serializable

@Serializable
data class Passenger(
    val id: Int,
    var firstName: String,
    var lastName: String,
    var documentId: String,
) {
    fun fullName(): String {
        return "$firstName $lastName"
    }
}