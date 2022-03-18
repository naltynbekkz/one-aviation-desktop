package main.logs.reservation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            }
        }
    }
}