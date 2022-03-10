package main.logs.logs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.EmptyResponseHandler
import core.ResponseComponent
import core.hover
import theme.gray600

@Composable
fun LogsScreen(
    component: LogsComponent,
    goToReservation: (Long) -> Unit,
) {

    val verticalScrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Logs")
                },
                backgroundColor = MaterialTheme.colors.background,
                actions = {
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
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(40.dp)
                                                .hover {
                                                    drawRect(
                                                        color = Color.Green,
                                                        alpha = 0.3f,
                                                    )
                                                },
                                        ) {
                                            Text(index.toTime(), Modifier.padding(start = 8.dp, top = 2.dp))
                                            if (flights.isNotEmpty()) {
                                                val flight = remember { flights[0] }
                                                Text(
                                                    flight.toString(),
                                                    modifier = Modifier
                                                        .weight(1f)
                                                        .fillMaxHeight()
                                                        .background(color = MaterialTheme.colors.primary.copy(0.2f))
                                                        .clickable {
                                                            goToReservation(flight.id)
                                                        }
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