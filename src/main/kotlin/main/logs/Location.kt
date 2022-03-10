package main.logs

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val long: Float,
    val lat: Float,
    val address: String,
)