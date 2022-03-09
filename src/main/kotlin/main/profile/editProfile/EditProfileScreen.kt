package main.profile.editProfile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EditProfileScreen(
    editProfileComponent: EditProfileComponent,
    navigateUp: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Edit Profile")
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
            var password: String by remember { mutableStateOf("") }
            var confirmPassword: String by remember { mutableStateOf("") }
            var isVisible: Boolean by remember { mutableStateOf(false) }
            var email: String by remember { mutableStateOf("") }
            var dateOfBirth: String by remember { mutableStateOf("") }

            val radioOptions = listOf("Male", "Female")
            val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Edit personal data", modifier = Modifier.padding(16.dp), fontSize = 24.sp
                )

                OutlinedTextField(value = username,
                    onValueChange = { username = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Name") })

                OutlinedTextField(value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Surname") })

                OutlinedTextField(value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Phone Number") })

                OutlinedTextField(value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Email address") })

                OutlinedTextField(value = dateOfBirth,
                    onValueChange = { dateOfBirth = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Date of birth") })

                Text(
                    text = "Gender",
                    modifier = Modifier.padding(12.dp),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )

                radioOptions.forEach { text ->
                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = { onOptionSelected(text) }
                            ),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = {
                                onOptionSelected(text)
                            }
                        )
                        Text(
                            text = text,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Button(onClick = {
                    isVisible = true
                }) {
                    Text("Edit profile")
                }

                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.Bottom
                ) {
                    if (isVisible) {
                        Snackbar(
                            action = {
                                TextButton(onClick = { isVisible = false }) {
                                    Text(text = "Hide", color = Color.White)
                                }
                            }, modifier = Modifier.padding(4.dp)
                        ) {
                            Text(text = "Password is changed successfully")
                        }
                    }
                }

            }
        }
    }
}