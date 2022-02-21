package network

import core.Timestamp
import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    var id: Long,
    var uuid: String,
    var timestamp: Timestamp,
)