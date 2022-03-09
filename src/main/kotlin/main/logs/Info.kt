package main.logs

import kotlinx.serialization.Serializable

@Serializable
class Info(
    val time: Long,
    val location: Location,
)