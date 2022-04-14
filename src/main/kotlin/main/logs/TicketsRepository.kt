package main.logs

import network.ResponseState.NetworkResponse

interface TicketsRepository {

    suspend fun cancelTicket(id: Int): NetworkResponse<Unit>
    suspend fun uncancelTicket(id: Int): NetworkResponse<Unit>

}