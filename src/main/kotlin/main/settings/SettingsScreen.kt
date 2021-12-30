package main.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SettingsScreen(settingsComponent: SettingsComponent) {

    val nightMode by settingsComponent.nightMode.collectAsState()

    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Button({
            settingsComponent.setNightMode(!nightMode)
        }) {
            Text(if (nightMode) "Night" else "Day")
        }
    }
}