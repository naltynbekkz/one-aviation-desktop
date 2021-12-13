package network

import kotlinx.serialization.Serializable

@Serializable
data class TokenRequest(
    val refreshToken: String,
    val appVersion: String,
    val deviceOS: String = "desktop",
)