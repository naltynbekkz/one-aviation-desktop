package main.logs.logs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.DateUtils.added
import core.DateUtils.getStringTime
import core.DateUtils.toDate
import core.EmptyResponseHandler
import core.HoverCard
import core.ResponseComponent
import main.logs.Flight
import main.logs.FlightStatus
import theme.gray600
import java.util.Calendar
import kotlin.time.Duration.Companion.hours

@Composable
fun LogsScreen(
    component: LogsComponent,
    goToReservation: (Long) -> Unit,
    makeAReservation: (Calendar) -> Unit,
) {

    val verticalScrollState = rememberScrollState()

    val date by component.date.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Logs")
                },
                backgroundColor = MaterialTheme.colors.background,
                actions = {
                    IconButton(
                        onClick = {
                            component.setDate(date.added(days = -1))
                        },
                    ) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                    Text(date.toDate())
                    IconButton(
                        onClick = {
                            component.setDate(date.added(days = 1))
                        },
                    ) {
                        Icon(Icons.Default.ArrowForward, null)
                    }
                    IconButton(onClick = {
                        component.flights.refresh()
                    }) {
                        Icon(Icons.Default.Refresh, null)
                    }
                }
            )
        }
    ) {
        ResponseComponent(
            interactor = component.flights,
            emptyResponseHandler = EmptyResponseHandler(
                title = "There are no flights",
                subtitle = null,
                isEmpty = { it.isEmpty() })
        ) { planes ->

            LazyRow(Modifier.fillMaxSize()) {
                items(planes) {
                    Card(Modifier.padding(vertical = 16.dp, horizontal = 8.dp).width(240.dp)) {
                        Column {
                            Row(Modifier.height(64.dp).fillMaxWidth()) {
                                Box(
                                    Modifier.padding(8.dp).size(48.dp)
                                        .background(MaterialTheme.colors.gray600, RoundedCornerShape(50))
                                )
                                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                                    Text("Plane")
                                    Text(it.first.name)
                                }
                            }
                            Box(
                                Modifier.fillMaxHeight().verticalScroll(verticalScrollState)
                            ) {
                                Column(Modifier.fillMaxWidth()) {
                                    it.second.forEachIndexed { index, flights ->
                                        if (index % 2 == 0) {
                                            Divider()
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(80.dp),
                                        ) {
                                            if (flights.isNotEmpty()) {
                                                val flight = remember { flights[0] }
                                                LogItem(
                                                    flight = flight,
                                                    setStatus = { component.updateFlight.initialFetch(flight.id to it) },
                                                    modifier = Modifier.fillMaxSize()
                                                        .clickable(onClick = { goToReservation(flight.id) }),
                                                )
                                            } else {
                                                Text(
                                                    index.toTime(),
                                                    Modifier.padding(start = 8.dp, top = 2.dp),
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LogItem(
    flight: Flight,
    setStatus: (FlightStatus) -> Unit,
    modifier: Modifier = Modifier,
) {

    val backgroundColor = when (flight.status) {
        FlightStatus.BOOKING -> Color.Yellow
        FlightStatus.SERVED -> MaterialTheme.colors.secondary
        FlightStatus.CANCELLED -> Color.Red
    }

    HoverCard {
        Column(modifier = modifier.background(color = backgroundColor.copy(alpha = 0.24f))) {
            Row(
                modifier = Modifier.background(color = backgroundColor)
            ) {
                Text(
                    text = getStringTime(flight.departure.time) + " - " + getStringTime(flight.departure.time + 0.5.hours.inWholeMilliseconds),
                    style = MaterialTheme.typography.caption,
                )
                Spacer(modifier = Modifier.weight(1f))
                if (flight.status != FlightStatus.SERVED) {
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .size(16.dp)
                            .background(
                                color = MaterialTheme.colors.secondary,
                                shape = CircleShape,
                            )
                            .clickable {
                                setStatus(FlightStatus.SERVED)
                            }
                    )
                }
                if (flight.status != FlightStatus.BOOKING) {
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .size(16.dp)
                            .background(
                                color = Color.Yellow,
                                shape = CircleShape,
                            )
                            .clickable {
                                setStatus(FlightStatus.BOOKING)
                            }
                    )
                }
                if (flight.status != FlightStatus.CANCELLED) {
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .size(16.dp)
                            .background(
                                color = Color.Red,
                                shape = CircleShape,
                            )
                            .clickable {
                                setStatus(FlightStatus.CANCELLED)
                            }
                    )
                }
            }
            Text("From: ${flight.departure.location.address}", style = MaterialTheme.typography.caption)
            Text("To: ${flight.arrival.address}", style = MaterialTheme.typography.caption)
            Text("${flight.passengerCount} passenger(s)", style = MaterialTheme.typography.caption)
        }
    }
}

fun Int.toTime(): String {
    val hours = this / 2
    val minutes = (this % 2) * 30
    return buildString {
        if (hours < 10) append("0")
        append(hours)
        append(":")
        if (minutes < 10) append("0")
        append(minutes)
    }
}