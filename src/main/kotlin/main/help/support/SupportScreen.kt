package main.help.support

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

@Composable
fun SupportScreen(component: SupportComponent) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Support", modifier = Modifier.padding(start = 20.dp))
                },
                backgroundColor = MaterialTheme.colors.background,
            )
        }
    ) {
        Column(modifier = Modifier.padding(horizontal = 64.dp, vertical = 46.dp).fillMaxSize()) {
            Text(
                text = "If you have problems or questions about the application, then you can contact a support team by email",
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Text(text = "oneaviationsupport@one.com", modifier = Modifier.padding(bottom = 12.dp), color = Color.Blue)
            Text(text = "or you can call by", modifier = Modifier.padding(bottom = 12.dp))
            Text(text = "+770236565487", color = Color.Blue)
        }
    }
}