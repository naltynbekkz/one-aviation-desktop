package main.profile.profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen(
    profileScreenComponent: ProfileComponent,
    navigateToChangePassword: () -> Unit,
    navigateToEditProfile: () -> Unit
) {

    val token by profileScreenComponent.refreshToken.collectAsState()

    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            Button(onClick = {
                navigateToChangePassword.invoke()
            }) {
                Text("Change Password")
            }

            Button(onClick = {
                navigateToEditProfile.invoke()
            }) {
                Text("Edit Profile")
            }

            AnimatedVisibility(token != null) {
                Button({
                    profileScreenComponent.setRefreshToken(null)
                }) {
                    Text("Log out")
                }
            }
        }
    }
}