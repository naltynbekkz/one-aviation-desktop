package main.logs

import network.ResponseState.NetworkResponse

interface FlightsRepository {

    suspend fun getFlights(): NetworkResponse<List<Flight>>
    suspend fun getFlight(id: Long): NetworkResponse<Flight>

}