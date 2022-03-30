package main.service.services

data class Service(
    val id: Int,
    val name: String,
    val priceMin: Int?,
    val priceMax: Int?,
    val duration: Int,
    val description: String,
    val staffCount: Int,
)
