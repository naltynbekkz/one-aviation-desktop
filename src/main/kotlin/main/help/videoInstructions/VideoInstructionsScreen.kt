package main.help.videoInstructions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VideoInstructionsScreen(component: VideoInstructionsComponent) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Video instructions", modifier = Modifier.padding(start = 20.dp))
                },
                backgroundColor = MaterialTheme.colors.background,
            )
        }
    ) {
        Column(modifier = Modifier.padding(horizontal = 64.dp, vertical = 46.dp).fillMaxSize()) {
            Text(
                text = "We have prepared the video instructions of how to use the application.",
                modifier = Modifier.padding(bottom = 12.dp),
                fontSize = 18.sp
            )
            Text(
                text = "Thus if you want to watch the video version of the instructions just click the",
                modifier = Modifier.padding(bottom = 12.dp),
                fontSize = 18.sp
            )
            Text(text = "link", color = Color.Blue, fontSize = 18.sp)
        }
    }
}