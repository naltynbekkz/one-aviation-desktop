package main.staff.admins.admin

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
import main.staff.admins.addAdmin.RegistrationRequest
import network.ResponseState

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun AdminScreen(
    component: AdminComponent,
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
                    Text("Admin")
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
                        component.admin.refresh()
                    }) {
                        Icon(Icons.Default.Refresh, null)
                    }
                }
            )
        }
    ) {
        ResponseComponent(
            interactor = component.admin,
        ) { admin ->
            var username by remember { mutableStateOf(admin.username) }
            var firstName by remember { mutableStateOf(admin.firstName) }
            var lastName by remember { mutableStateOf(admin.lastName) }
            var password by remember { mutableStateOf("") }

            var isEdit: Boolean by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Admin", modifier = Modifier.padding(16.dp), fontSize = 24.sp
                )

                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Username") },
                    enabled = isEdit
                )

                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("FirstName") },
                    enabled = isEdit
                )

                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("LastName") },
                    enabled = isEdit
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Password") },
                    enabled = isEdit
                )

                LoadingGreenButton(
                    text = if (!isEdit) "Edit" else "Save",
                    isLoading = responseState is ResponseState.Loading,
                ) {
                    if (isEdit) {
                        component.edit.initialFetch(
                            admin.id to RegistrationRequest(
                                username = username,
                                firstName = firstName,
                                lastName = lastName,
                                password = password,
                            )
                        )
                    }
                    isEdit = !isEdit
                }
            }
        }
    }

}