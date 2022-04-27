package main.logs.reservation

import core.CustomComponentContext
import core.Interactor.Companion.getInteractor
import core.NullableInteractor.Companion.getNullableInteractor
import main.logs.FlightsRepository
import main.logs.TicketsRepository
import main.staff.masters.PlanesRepository
import main.staff.masters.data.Plane
import network.ResponseState

class ReservationComponent(
    customComponentContext: CustomComponentContext,
    private val id: Long,
    repository: FlightsRepository,
    planesRepository: PlanesRepository,
    ticketsRepository: TicketsRepository,
) : CustomComponentContext by customComponentContext {

    val flight = getInteractor {
        repository.getFlight(id)
    }

    val changePlane = getNullableInteractor { plane: Plane ->
        repository.changePlane(id.toInt(), plane)
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

    val planes = getInteractor {
        planesRepository.getPlanes()
    }

}