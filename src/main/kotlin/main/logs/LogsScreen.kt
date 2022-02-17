package main.logs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.hover
import theme.gray600

@Composable
fun LogsScreen(component: LogsComponent) {

    val colors = List(15) {
        List(48) { it * 30 }
    }

    val verticalScrollState = rememberScrollState()

    LazyRow(Modifier.fillMaxSize()) {
        items(colors) {
            Card(Modifier.padding(vertical = 16.dp, horizontal = 8.dp).width(240.dp)) {
                Column {
                    Row(Modifier.height(64.dp).fillMaxWidth()) {
                        Box(
                            Modifier.padding(8.dp).size(48.dp)
                                .background(MaterialTheme.colors.gray600, RoundedCornerShape(50))
                        )
                        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                            Text("FirstName LastName")
                            Text("Plane")
                        }
                    }
                    Box(
                        Modifier.fillMaxHeight().verticalScroll(verticalScrollState)
                    ) {
                        Column(Modifier.fillMaxWidth()) {
                            it.forEach {
                                if (it % 60 == 0) {
                                    Divider()
                                }
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(40.dp)
                                        .hover {
                                            drawRect(
                                                color = Color.Green,
                                                alpha = 0.3f,
                                            )
                                        },
                                ) {
                                    Text(it.toTime(), Modifier.padding(start = 8.dp, top = 2.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun Int.toTime(): String {
    val hours = this / 60
    val minutes = this % 60
    return buildString {
        if (hours < 10) append("0")
        append(hours)
        append(":")
        if (minutes < 10) append("0")
        append(minutes)
    }
}