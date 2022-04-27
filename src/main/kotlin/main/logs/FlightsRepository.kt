package main.logs

import main.logs.logs.LogsResponse
import main.logs.newReservation.NewReservationScreenData
import main.staff.masters.data.Plane
import network.ResponseState.NetworkResponse

interface FlightsRepository {

    suspend fun getFlights(from: Long, to: Long): NetworkResponse<List<LogsResponse>>
    suspend fun getFlight(id: Long): NetworkResponse<Flight>
    suspend fun updateFlight(id: Long, flightStatus: FlightStatus): NetworkResponse<Flight>
    suspend fun getNewReservationScreenData(): NetworkResponse<NewReservationScreenData>

    suspend fun changePlane(flightId: Int, plane: Plane): NetworkResponse<Unit>

}