package main.logs

import network.ResponseState.NetworkResponse

interface FlightsRepository {

    suspend fun getFlights(from: Long, to: Long): NetworkResponse<List<Flight>>
    suspend fun getFlight(id: Long): NetworkResponse<Flight>
    suspend fun updateFlight(id: Long, flightStatus: FlightStatus): NetworkResponse<Flight>

}