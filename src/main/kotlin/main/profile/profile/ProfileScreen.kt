package main.profile.profile

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
import core.LoadingGreenButton
import network.ResponseState

@Composable
fun ProfileScreen(
    profileScreenComponent: ProfileComponent,
    navigateToChangePassword: () -> Unit,
    navigateToEditProfile: () -> Unit
) {

    val responseState by profileScreenComponent.signOut.response.collectAsState()

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

            LoadingGreenButton(
                text = "Log out",
                isLoading = responseState is ResponseState.Loading,
            ) {
                profileScreenComponent.signOut.initialFetch(Unit)
            }
        }
    }
}