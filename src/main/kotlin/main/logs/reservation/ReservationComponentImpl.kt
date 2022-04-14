package main.logs.reservation

import core.CustomComponentContext
import core.Interactor.Companion.getInteractor
import core.NullableInteractor.Companion.getNullableInteractor
import main.logs.FlightsRepository
import main.logs.TicketsRepository
import network.ResponseState

class ReservationComponent(
    customComponentContext: CustomComponentContext,
    private val id: Long,
    repository: FlightsRepository,
    ticketsRepository: TicketsRepository,
) : CustomComponentContext by customComponentContext {

    val flight = getInteractor {
        repository.getFlight(id)
    }

    val cancelTicket = getNullableInteractor { id: Int ->
        val response = ticketsRepository.cancelTicket(id)
        if (response is ResponseState.NetworkResponse.Success) {
            flight.refresh()
        }
        response
    }

    val uncancelTicket = getNullableInteractor { id: Int ->
        val response = ticketsRepository.uncancelTicket(id)
        if (response is ResponseState.NetworkResponse.Success) {
            flight.refresh()
        }
        response

    }

}