package main.logs.reservation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.DateUtils
import core.ResponseComponent

@Composable
fun ReservationScreen(
    component: ReservationComponent,
    navigateUp: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Flight")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back button",
                            tint = MaterialTheme.colors.primary,
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.background,
                actions = {
                    IconButton(onClick = {
                        component.flight.refresh()
                    }) {
                        Icon(Icons.Default.Refresh, null)
                    }
                }
            )
        }
    ) {
        ResponseComponent(
            interactor = component.flight,
        ) { flight ->
            var arrival by remember { mutableStateOf(flight.arrival.address) }
            var departure by remember { mutableStateOf(flight.departure.location.address) }
            var status by remember { mutableStateOf(flight.status.name) }
            var plane by remember { mutableStateOf(flight.plane.name) }

            var isEdit by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Flight Info", modifier = Modifier.padding(16.dp), fontSize = 24.sp
                )

                OutlinedTextField(
                    value = DateUtils.getMilitaryTime(flight.departure.time),
                    onValueChange = { },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Departure time") },
                    enabled = isEdit
                )

                OutlinedTextField(
                    value = departure,
                    onValueChange = { departure = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Departure") },
                    enabled = isEdit
                )


                OutlinedTextField(
                    value = arrival,
                    onValueChange = { arrival = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Arrival") },
                    enabled = isEdit
                )

                OutlinedTextField(
                    value = plane,
                    onValueChange = { plane = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Plane") },
                    enabled = isEdit
                )

                OutlinedTextField(
                    value = status,
                    onValueChange = { status = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Status") },
                    enabled = isEdit
                )

                Text(
                    text = "Tickets", modifier = Modifier.padding(16.dp), fontSize = 24.sp
                )

                flight.tickets.forEach { ticket ->
                    Card(
                        modifier = Modifier.padding(vertical = 4.dp),
                    ) {
                        Column(
                            modifier = Modifier.padding(8.dp).width(256.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text("Ticket#${ticket.id}")
                                Spacer(modifier = Modifier.weight(1f))
                                if (ticket.timestamp.deleted == null) {
                                    Box(
                                        modifier = Modifier
                                            .padding(2.dp)
                                            .size(16.dp)
                                            .background(
                                                color = Color.Red,
                                                shape = CircleShape,
                                            )
                                            .clickable {
                                                component.cancelTicket.initialFetch(ticket.id)
                                            }
                                    )
                                } else {
                                    Box(
                                        modifier = Modifier
                                            .padding(2.dp)
                                            .size(16.dp)
                                            .background(
                                                color = MaterialTheme.colors.secondary,
                                                shape = CircleShape,
                                            )
                                            .clickable {
                                                component.uncancelTicket.initialFetch(ticket.id)
                                            }
                                    )
                                }
                            }
                            Text("Passenger", color = Color.Gray)
                            Text(ticket.passenger.fullName())
                            Text("Document Id: ${ticket.passenger.documentId}")
                            Text(buildAnnotatedString {
                                append("Status: ")
                                if (ticket.timestamp.deleted == null) {
                                    withStyle(SpanStyle(MaterialTheme.colors.secondary)) {
                                        append("ACTIVE")
                                    }
                                } else {
                                    withStyle(SpanStyle(Color.Red)) {
                                        append("CANCELLED")
                                    }
                                }
                            })
                        }
                    }
                }
            }
        }
    }
}