package main.logs

import kotlinx.serialization.Serializable

@Serializable
data class Info(
    val time: Long,
    val location: Location,
)