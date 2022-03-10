package network.impl

import main.logs.Flight
import main.logs.FlightsRepository
import network.BaseRepository

class FlightsRepositoryImpl : BaseRepository("flights"), FlightsRepository {
    override suspend fun getFlights() =
        get<List<Flight>>()

    override suspend fun getFlight(id: Long) =
        get<Flight>("/$id")
}