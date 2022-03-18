package main.logs.logs

import com.arkivanov.decompose.ComponentContext
import core.DateUtils
import core.DateUtils.added
import core.DependentInteractor.Companion.getDependentInteractor
import core.NullableInteractor.Companion.getNullableInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import main.logs.FlightStatus
import main.logs.FlightsRepository
import network.ResponseState
import network.ResponseState.Companion.convert
import java.util.*

class LogsComponentImpl(
    componentContext: ComponentContext,
    repository: FlightsRepository,
) : LogsComponent, ComponentContext by componentContext {

    override val date = MutableStateFlow(DateUtils.getMidnight())
    override fun setDate(calendar: Calendar) {
        date.value = calendar
    }

    override val flights = getDependentInteractor(date) {
        repository.getFlights(it.timeInMillis, it.added(days = 1).timeInMillis).convert {
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

    override val updateFlight = getNullableInteractor { pair: Pair<Long, FlightStatus> ->
        val response = repository.updateFlight(pair.first, pair.second)
        if (response is ResponseState.NetworkResponse.Success) {
            flights.refresh()
        }
        response
    }
}