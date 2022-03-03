package main.storage.turnover

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import main.storage.turnover.data.PlaneHomeContent

@Composable
fun TurnoverScreen(component: TurnoverComponent) {

    /*Box(Modifier.fillMaxSize(), Alignment.Center) {
        Text("TurnoverScreen")
    }*/

    Scaffold(
        floatingActionButton = { FloatingActionButton(onClick = {}) {} },
        content = {
            PlaneHomeContent()
        }
    )
}