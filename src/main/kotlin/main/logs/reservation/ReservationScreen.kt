package main.logs.reservation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.sun.net.httpserver.Authenticator.Success
import core.DateUtils
import core.ResponseComponent
import main.allTabs
import network.ResponseState

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
            var plane by remember { mutableStateOf(flight.plane) }

            var isEdit by remember { mutableStateOf(false) }

            var textfieldSize by remember { mutableStateOf(Size.Zero) }
            var expanded by remember { mutableStateOf(false) }

            val planes = component.planes.response.collectAsState()

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

                Column {
                    OutlinedTextField(
                        value = plane.name,
                        onValueChange = {  },
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth()
                            .onGloballyPositioned { coordinates ->
                                //This value is used to assign to the DropDown the same width
                                textfieldSize = coordinates.size.toSize()
                            },
                        label = { Text("Plane") },
                        readOnly = true,
                        trailingIcon = {
                            Icon(Icons.Filled.ArrowDropDown, "contentDescription",
                                Modifier.clickable {
                                    expanded = true
                                })
                        }
                    )

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
                    ) {
                        (planes.value as? ResponseState.NetworkResponse.Success)?.data?.forEach {
                            DropdownMenuItem(onClick = {
                                expanded = false
                                plane = it
                            }) {
                                Text(text = it.name)
                            }
                        }
                    }
                }

                OutlinedTextField(
                    value = status,
                    onValueChange = { status = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Status") },
                    enabled = isEdit
                )

                AnimatedVisibility(flight.plane != plane) {
                    Button(
                        onClick = {
                            component.changePlane.initialFetch(plane)
                        },
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                        content = {
                            Text("Save")
                        }
                    )
                }

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