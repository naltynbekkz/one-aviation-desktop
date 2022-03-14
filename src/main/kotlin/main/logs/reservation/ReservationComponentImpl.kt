package main.logs.reservation

import com.arkivanov.decompose.ComponentContext
import core.Interactor.Companion.getInteractor
import main.logs.FlightsRepository

class ReservationComponentImpl(
    componentContext: ComponentContext,
    private val id: Long,
    repository: FlightsRepository,
) : ReservationComponent, ComponentContext by componentContext {

    override val flight = getInteractor {
        repository.getFlight(id)
    }

}