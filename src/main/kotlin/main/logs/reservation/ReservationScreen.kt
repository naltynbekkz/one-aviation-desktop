package main.logs.reservation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.ResponseComponent
import theme.green

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

            Box(Modifier.fillMaxSize(), Alignment.Center) {

                var arrival: String by remember { mutableStateOf(flight.arrival.address) }
                var departure: String by remember { mutableStateOf(flight.departure.location.address) }
                var status: String by remember { mutableStateOf(flight.status.name) }
                var timestamp: String by remember { mutableStateOf(flight.timestamp.created.toString()) }
                var plane: String by remember { mutableStateOf(flight.plane.name) }

                var isEdit: Boolean by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Flight Info", modifier = Modifier.padding(16.dp), fontSize = 24.sp
                    )

                    OutlinedTextField(
                        value = arrival,
                        onValueChange = { arrival = it },
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                        label = { Text("Arrival") },
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

                    OutlinedTextField(
                        value = timestamp,
                        onValueChange = { timestamp = it },
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                        label = { Text("Timestamp") },
                        enabled = isEdit
                    )

                    Button(
                        onClick = { isEdit = !isEdit }, colors = if (isEdit) {
                            ButtonDefaults.buttonColors(green, Color.White)
                        } else {
                            ButtonDefaults.buttonColors()
                        }
                    ) {
                        if (!isEdit) {
                            Text(text = "Edit")
                        } else {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}