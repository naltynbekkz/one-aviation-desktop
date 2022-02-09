package main.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(profileComponent: ProfileComponent) {

    val token by profileComponent.refreshToken.collectAsState()
    var isVisible: Boolean by remember { mutableStateOf(false) }

    if (token != null) {
        Box(Modifier.fillMaxSize(), Alignment.Center) {

            var username: String by remember { mutableStateOf("") }
            var password: String by remember { mutableStateOf("") }
            var confirmPassword: String by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Change password", modifier = Modifier.padding(16.dp), fontSize = 24.sp
                )

                OutlinedTextField(value = username,
                    onValueChange = { username = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Current password") })

                OutlinedTextField(value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("New Password") })

                OutlinedTextField(value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp).wrapContentWidth(),
                    label = { Text("Confirm Password") })

                Button(onClick = {
                    isVisible = true
                }) {
                    Text("Change the password")
                }

                Button({
                    profileComponent.setRefreshToken(null)
                }) {
                    Text("Log out")
                }
            }
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