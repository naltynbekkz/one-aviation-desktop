package main.logs.logs

import core.CustomComponentContext
import core.DateUtils
import core.DateUtils.added
import core.DependentInteractor
import core.DependentInteractor.Companion.getDependentInteractor
import core.NullableInteractor.Companion.getNullableInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import main.logs.Flight
import main.logs.FlightStatus
import main.logs.FlightsRepository
import main.staff.masters.data.Plane
import network.ResponseState
import network.ResponseState.Companion.convert
import java.util.*

class LogsComponent(
    customComponentContext: CustomComponentContext,
    repository: FlightsRepository,
) : CustomComponentContext by customComponentContext {

    val date = MutableStateFlow(DateUtils.getMidnight())
    fun setDate(calendar: Calendar) {
        date.value = calendar
    }

    val flights = getDependentInteractor(date) {
        repository.getFlights(it.timeInMillis, it.added(days = 1).timeInMillis).convert {
            it.map {
                val flights = it.flights.groupBy {
                    val calendar = Calendar.getInstance()
                    calendar.timeInMillis = it.departure.time
                    val hour = calendar.get(Calendar.HOUR_OF_DAY)
                    val minutes = calendar.get(Calendar.MINUTE)
                    hour * 2 + minutes / 30
                }

                val list = List(48) { flights[it] ?: listOf() }

                it.plane to list
            }.toList()
        }
    }

    val updateFlight = getNullableInteractor { pair: Pair<Long, FlightStatus> ->
        val response = repository.updateFlight(pair.first, pair.second)
        if (response is ResponseState.NetworkResponse.Success) {
            flights.refresh()
        }
        response
    }
}