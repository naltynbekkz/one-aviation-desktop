package network.impl

import main.logs.Flight
import main.logs.FlightStatus
import main.logs.FlightsRepository
import main.logs.UpdateFlightRequest
import main.logs.logs.LogsResponse
import main.logs.newReservation.NewReservationScreenData
import network.BaseRepository
import network.ResponseState

class FlightsRepositoryImpl : BaseRepository("flights"), FlightsRepository {
    override suspend fun getFlights(from: Long, to: Long) =
        get<List<LogsResponse>>(queryParams = listOf("from" to from, "to" to to))

    override suspend fun getFlight(id: Long) =
        get<Flight>("/$id")

    override suspend fun updateFlight(id: Long, flightStatus: FlightStatus) =
        put<Flight>("/$id", UpdateFlightRequest(flightStatus))

    override suspend fun getNewReservationScreenData() =
        get<NewReservationScreenData>("/new")
}