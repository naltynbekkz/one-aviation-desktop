package core

import kotlinx.serialization.Serializable

@Serializable
data class Timestamp(
    var created: Long,
    var updated: Long,
    var deleted: Long?,
)