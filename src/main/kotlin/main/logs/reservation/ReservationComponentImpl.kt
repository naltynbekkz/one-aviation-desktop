package main.logs.reservation

import core.CustomComponentContext
import core.Interactor.Companion.getInteractor
import main.logs.FlightsRepository

class ReservationComponent(
    customComponentContext: CustomComponentContext,
    private val id: Long,
    repository: FlightsRepository,
) : CustomComponentContext by customComponentContext {

    val flight = getInteractor {
        repository.getFlight(id)
    }

}