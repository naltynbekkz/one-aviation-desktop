package main.logs

import kotlinx.serialization.Serializable

@Serializable
class Location(
    val long: Float,
    val lat: Float,
    val address: String,
)