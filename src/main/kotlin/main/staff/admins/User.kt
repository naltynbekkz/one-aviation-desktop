package main.staff.admins

import core.Timestamp
import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id: Long,
    var username: String,
    var firstName: String,
    var lastName: String,
    var timestamp: Timestamp,
)