package main.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import core.CoreSettings
import settings.SettingsProviderImpl

@Composable
fun ProfileScreen(profileComponent: ProfileComponent) {

    val token by profileComponent.refreshToken.collectAsState()

    if (token != null) {
        Box(Modifier.fillMaxSize(), Alignment.Center) {
            Button({
                profileComponent.setRefreshToken(null)
            }) {
                Text("Log out")
            }
        }
    }
}