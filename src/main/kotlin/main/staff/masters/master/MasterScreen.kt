package main.staff.masters.master

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.LoadingGreenButton
import core.ResponseComponent
import network.ResponseState

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun MasterScreen(
    component: MasterComponent,
    navigateUp: () -> Unit,
) {

    val responseState by component.edit.response.collectAsState()

    LaunchedEffect(responseState) {
        if (responseState is ResponseState.NetworkResponse.Success) {
            navigateUp()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Plane")
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
                        component.plane.refresh()
                    }) {
                        Icon(Icons.Default.Refresh, null)
                    }
                }
            )
        }
    ) {
        ResponseComponent(
            interactor = component.plane,
        ) { plane ->

            var isEdit: Boolean by remember { mutableStateOf(false) }

            var name: String by remember { mutableStateOf(plane.name) }
            var mileage: String by remember { mutableStateOf(plane.mileage.toString()) }
            var price: String by remember { mutableStateOf(plane.price.toString()) }
            var capacity: String by remember { mutableStateOf(plane.capacity.toString()) }


            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Plane Info", modifier = Modifier.padding(16.dp), fontSize = 24.sp
                )

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Name") },
                    readOnly = !isEdit
                )

                OutlinedTextField(
                    value = mileage,
                    onValueChange = { mileage = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Mileage") },
                    readOnly = !isEdit
                )

                OutlinedTextField(
                    value = price,
                    onValueChange = { price = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Price") },
                    readOnly = !isEdit
                )

                OutlinedTextField(
                    value = capacity,
                    onValueChange = { capacity = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Capacity") },
                    readOnly = !isEdit
                )

                LoadingGreenButton(
                    text = if (!isEdit) "Edit" else "Save",
                    isLoading = responseState is ResponseState.Loading,
                ) {
                    if (isEdit) {
                        component.edit.initialFetch(
                            plane.id to EditPlaneRequest(
                                name = name,
                                mileage = mileage.toLong(),
                                capacity = capacity.toInt(),
                                price = price.toFloat(),
                            )
                        )
                    }
                    isEdit = !isEdit
                }
            }
        }
    }

}