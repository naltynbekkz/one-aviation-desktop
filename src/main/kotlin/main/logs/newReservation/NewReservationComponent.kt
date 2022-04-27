package main.logs.newReservation

import core.CustomComponentContext
import core.Interactor.Companion.getInteractor
import main.logs.FlightsRepository

class NewReservationComponent(
    customComponentContext: CustomComponentContext,
    repository: FlightsRepository,
) : CustomComponentContext by customComponentContext {

    val initialData = getInteractor {
        repository.getNewReservationScreenData()
    }

}