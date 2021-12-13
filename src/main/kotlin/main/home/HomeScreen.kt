package main.home

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
fun HomeScreen(homeComponent: HomeComponent) {

    val nightMode by homeComponent.nightMode.collectAsState()

    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Button({
            homeComponent.setNightMode(!nightMode)
        }) {
            Text(if (nightMode) "Night" else "Day")
        }
    }
}