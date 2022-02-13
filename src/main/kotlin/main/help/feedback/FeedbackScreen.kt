package main.help.feedback

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FeedbackScreen(component: FeedbackComponent) {

    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Text("FeedbackScreen")
    }

}