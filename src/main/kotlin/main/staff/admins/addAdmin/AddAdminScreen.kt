package main.staff.admins.addAdmin

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
fun AddAdminScreen(
    component: AddAdminComponent,
    navigateUp: () -> Unit,
) {

    val responseState by component.addAdmin.response.collectAsState()

    LaunchedEffect(responseState) {
        if (responseState is ResponseState.NetworkResponse.Success) {
            navigateUp()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Add admin")
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

            var username: String by remember { mutableStateOf("") }
            var firstName: String by remember { mutableStateOf("") }
            var lastName: String by remember { mutableStateOf("") }
            var password: String by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Add an admin", modifier = Modifier.padding(16.dp), fontSize = 24.sp
                )

                OutlinedTextField(value = username,
                    onValueChange = { username = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Username") })

                OutlinedTextField(value = firstName,
                    onValueChange = { firstName = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("FirstName") })

                OutlinedTextField(value = lastName,
                    onValueChange = { lastName = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("LastName") })

                OutlinedTextField(value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Password") })

                LoadingGreenButton(
                    text = "Create",
                    isLoading = responseState is ResponseState.Loading,
                ) {
                    component.addAdmin.initialFetch(
                        RegistrationRequest(
                            username = username,
                            firstName = firstName,
                            lastName = lastName,
                            password = password,
                        )
                    )
                }
            }
        }
    }

}