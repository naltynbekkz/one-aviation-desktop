package network

import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    val accessToken: String,
    val expiresIn: Long,
    val refreshToken: String,
)