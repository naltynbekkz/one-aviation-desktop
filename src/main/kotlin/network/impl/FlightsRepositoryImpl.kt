package network.impl

import main.logs.Flight
import main.logs.FlightsRepository
import network.BaseRepository

class FlightsRepositoryImpl : BaseRepository("flights"), FlightsRepository {
    override suspend fun getFlights() =
        get<List<Flight>>()
}