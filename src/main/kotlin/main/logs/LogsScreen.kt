package main.logs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LogsScreen(component: LogsComponent) {

    val colors = List(15) {
        List(48) { it * 30 }
    }

    val verticalScrollState = rememberScrollState()

    LazyRow(Modifier.fillMaxSize()) {
        items(colors) {
            Card(Modifier.padding(vertical = 16.dp, horizontal = 8.dp).width(240.dp)) {
                Box(
                    Modifier.fillMaxHeight().verticalScroll(verticalScrollState)
                ) {
                    Column(Modifier.fillMaxWidth()) {
                        it.forEach {
                            if (it % 60 == 0) {
                                Divider()
                            }
                            Box(Modifier.fillMaxWidth().height(40.dp)) {
                                val hours =
                                Text(it.toString())
                            }
                        }
                    }
                }
            }
        }
    }
}