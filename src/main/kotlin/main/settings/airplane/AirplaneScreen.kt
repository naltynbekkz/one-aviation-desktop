package main.settings.airplane

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.green

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AirplaneScreen(
    airplaneComponent: AirplaneComponent,
    navigateUp: () -> Unit
) {

    var airplaneName: String by remember { mutableStateOf("") }
    var phoneNumber: String by remember { mutableStateOf("") }
    var address: String by remember { mutableStateOf("") }
    var description: String by remember { mutableStateOf("") }
    var numberOfSeats: String by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Airplane")
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
            )
        }
    ) {

        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            cells = GridCells.Adaptive(600.dp),
        ) {

            items(1) {
                Card(
                    modifier = Modifier
                        .padding(24.dp)
                        .requiredHeight(640.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    elevation = 8.dp,
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Name of the airplane",
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        OutlinedTextField(value = airplaneName,
                            onValueChange = { airplaneName = it },
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).fillMaxWidth(),
                            label = { Text("Airplane name") })

                        Text(
                            text = "Phone numbers",
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        OutlinedTextField(value = phoneNumber,
                            onValueChange = { phoneNumber = it },
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).fillMaxWidth(),
                            label = { Text("Phone Number") })

                        Text(
                            text = "Address",
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        OutlinedTextField(value = address,
                            onValueChange = { address = it },
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).fillMaxWidth(),
                            label = { Text("Address") })

                        Text(
                            text = "Description of the airplane",
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        OutlinedTextField(value = description,
                            onValueChange = { description = it },
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).fillMaxWidth(),
                            label = { Text("Airplane description") })

                        Text(
                            text = "Number of available seats",
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        OutlinedTextField(value = numberOfSeats,
                            onValueChange = { numberOfSeats = it },
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).fillMaxWidth(),
                            label = { Text("Number of seats") })

                        Button(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 14.dp, bottom = 4.dp),
                            colors = ButtonDefaults.buttonColors(green),
                            onClick = {
                                navigateUp.invoke()
                            }) {
                            Text(text = "Save", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}