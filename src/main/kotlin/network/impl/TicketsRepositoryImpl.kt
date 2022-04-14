package network.impl

import main.logs.TicketsRepository
import network.BaseRepository

class TicketsRepositoryImpl : BaseRepository("tickets"), TicketsRepository {
    override suspend fun cancelTicket(id: Int) =
        delete<Unit>("/$id")

    override suspend fun uncancelTicket(id: Int) =
        put<Unit>("/$id", null)
}