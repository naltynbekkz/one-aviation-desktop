package main.logs.logs

import com.arkivanov.decompose.ComponentContext
import core.Interactor.Companion.getInteractor
import main.logs.FlightsRepository
import network.ResponseState.Companion.convert
import java.util.Calendar

class LogsComponentImpl(
    componentContext: ComponentContext,
    repository: FlightsRepository,
) : LogsComponent, ComponentContext by componentContext {
    override val flights = getInteractor {
        repository.getFlights().convert {
            it.groupBy { it.plane }.map {
                val flights = it.value.groupBy {
                    val calendar = Calendar.getInstance()
                    calendar.timeInMillis = it.departure.time
                    val hour = calendar.get(Calendar.HOUR_OF_DAY)
                    val minutes = calendar.get(Calendar.MINUTE)
                    hour * 2 + minutes / 30
                }

                val list = List(48) { flights[it] ?: listOf() }

                it.key to list
            }.toList()
        }
    }
}