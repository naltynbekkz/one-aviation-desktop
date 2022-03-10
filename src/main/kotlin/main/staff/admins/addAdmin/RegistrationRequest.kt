package main.staff.admins.addAdmin

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationRequest(
    var username: String,
    var firstName: String,
    var lastName: String,
    var password: String,
)