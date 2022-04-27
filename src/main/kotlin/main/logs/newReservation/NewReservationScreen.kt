package main.logs.newReservation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import core.ResponseComponent
import main.logs.Location
import main.logs.reservation.Passenger
import main.staff.masters.data.Plane
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

@Composable
fun NewReservationScreen(
    component: NewReservationComponent,
    navigateUp: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("New Flight")
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
                        component.initialData.refresh()
                    }) {
                        Icon(Icons.Default.Refresh, null)
                    }
                }
            )
        }
    ) {
        ResponseComponent(
            interactor = component.initialData,
        ) { initialData ->

            var selectedPlane by remember { mutableStateOf<Plane?>(null) }
            var planesExpanded by remember { mutableStateOf(false) }
            var planesTextFieldSize by remember { mutableStateOf(Size.Zero) }

            var passengersExpanded by remember { mutableStateOf(false) }
            val selectedPassengers = remember { mutableStateListOf<Passenger>() }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    value = selectedPlane?.name ?: "plane not selected",
                    onValueChange = { },
                    modifier = Modifier
                        .onGloballyPositioned { coordinates ->
                            planesTextFieldSize = coordinates.size.toSize()
                        },
                    label = { Text("Plane") },
                    readOnly = true,
                    trailingIcon = {
                        Icon(Icons.Filled.ArrowDropDown, "contentDescription",
                            Modifier.clickable { planesExpanded = !planesExpanded })
                    }
                )
                DropdownMenu(
                    expanded = planesExpanded,
                    onDismissRequest = { planesExpanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { planesTextFieldSize.width.toDp() })
                ) {
                    initialData.planes.forEach { plane ->
                        DropdownMenuItem(onClick = {
                            selectedPlane = plane
                            planesExpanded = false
                        }) {
                            Text(text = plane.name)
                        }
                    }
                }

                Text(
                    text = "Selected Passengers"
                )

                selectedPassengers.forEach {
                    Card(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                            .clickable {
                                selectedPassengers.remove(it)
                            }
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text("Passenger", color = Color.Gray)
                            Text(it.fullName())
                            Text("Document Id: ${it.documentId}")
                        }
                    }
                }



                DropdownMenu(
                    expanded = passengersExpanded,
                    onDismissRequest = { passengersExpanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { planesTextFieldSize.width.toDp() })
                ) {
                    initialData.passengers
                        .filter { !selectedPassengers.contains(it) }
                        .forEach {
                            DropdownMenuItem(onClick = {
                                selectedPassengers.add(it)
                                passengersExpanded = false
                            }) {
                                Text(text = it.fullName())
                            }
                        }
                }
            }
        }
    }
}

@Composable
fun LocationInput(
    text: String,
    imageVector: ImageVector,
    location: MutableState<Location?>,
) {
    FlightDetailInput(
        text = location.value?.let {
            it.address ?: "Unknown location"
        } ?: text,
        onClick = {
            location.value = Location(Random.nextFloat(), Random.nextFloat(), "Random address")
        },
        imageVector = imageVector,
    )
}

@Composable
fun DatesUserInput(
    time: MutableState<Calendar?>,
) {

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FlightDetailInput(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
    imageVector: ImageVector,
) {
    Surface(
        modifier = modifier,
        onClick = onClick,
        color = MaterialTheme.colors.primary
    ) {
        Row(Modifier.padding(all = 12.dp)) {
            Icon(
                imageVector = imageVector,
                contentDescription = "",
                modifier = Modifier.size(24.dp, 24.dp),
                tint = LocalContentColor.current
            )
            Spacer(Modifier.width(8.dp))
            Text(text, Modifier.weight(1f))
        }
    }
}