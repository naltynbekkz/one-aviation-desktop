package main.staff.masters.addMaster

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.LoadingGreenButton
import network.ResponseState

@Composable
fun AddMasterScreen(
    component: AddMasterComponent,
    navigateUp: () -> Unit,
) {

    val responseState by component.addMaster.response.collectAsState()

    LaunchedEffect(responseState) {
        if (responseState is ResponseState.NetworkResponse.Success) {
            navigateUp()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Add plane")
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
        Box(Modifier.fillMaxSize(), Alignment.Center) {

            var name: String by remember { mutableStateOf("") }
            var mileage: String by remember { mutableStateOf("") }
            var capacity: String by remember { mutableStateOf("") }
            var price: String by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Add a plane", modifier = Modifier.padding(16.dp), fontSize = 24.sp
                )

                OutlinedTextField(value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Name") })

                OutlinedTextField(value = mileage,
                    onValueChange = { mileage = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Mileage") })

                OutlinedTextField(value = capacity,
                    onValueChange = { capacity = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Capacity") })

                OutlinedTextField(value = price,
                    onValueChange = { price = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Price") })

                LoadingGreenButton(
                    text = "Create",
                    isLoading = responseState is ResponseState.Loading,
                ) {
                    component.addMaster.initialFetch(
                        CreatePlaneRequest(
                            name = name,
                            mileage = mileage.toLong(),
                            capacity = capacity.toInt(),
                            price = price.toFloat(),
                        )
                    )
                }
            }
        }
    }

}