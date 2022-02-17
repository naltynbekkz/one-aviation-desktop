package main.logs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import theme.gray100
import kotlin.random.Random

@Composable
fun LogsScreen(component: LogsComponent) {

    val colors = List(15) {
        List(10) {
            Color(
                red = Random.nextInt() % 256,
                green = Random.nextInt() % 256,
                blue = Random.nextInt() % 256,
                alpha = 255
            )
        }
    }

    val verticalScrollState = rememberScrollState()

    LazyRow(Modifier.fillMaxSize()) {
        items(colors) {
            Column(
                Modifier.padding(horizontal = 8.dp).width(240.dp).fillMaxHeight().verticalScroll(verticalScrollState)
            ) {
                Spacer(Modifier.height(16.dp))
                it.forEach {
                    Box(Modifier.fillMaxWidth().height(80.dp).background(it))
                }
                Spacer(Modifier.height(16.dp))
            }
        }
    }

}