package network.impl

import main.logs.Flight
import main.logs.FlightsRepository
import network.BaseRepository

class FlightsRepositoryImpl : BaseRepository("flights"), FlightsRepository {
    override suspend fun getFlights(from: Long, to: Long) =
        get<List<Flight>>(queryParams = listOf("from" to from, "to" to to))

    override suspend fun getFlight(id: Long) =
        get<Flight>("/$id")
}