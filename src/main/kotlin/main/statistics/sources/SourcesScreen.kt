package main.statistics.sources

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import main.statistics.compose.LineChart

@Composable
fun SourcesScreen(component: SourcesComponent) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            modifier = Modifier.padding(16.dp).fillMaxSize(0.8f),
            elevation = 2.dp,
        ) {

            Column(
                modifier = Modifier.fillMaxSize().padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {

                Text(
                    text = "Количество записей по источникам",
                    style = MaterialTheme.typography.h5,
                )
                Text(
                    text = "Выберите отображение источников",
                    style = MaterialTheme.typography.subtitle1,
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    component.entries.forEach {
                        Box(
                            modifier = Modifier
                                .background(it.color, RoundedCornerShape(50))
                                .padding(vertical = 4.dp, horizontal = 8.dp),
                        ) {
                            Text(
                                text = it.label,
                                color = Color.White,
                            )
                        }
                    }
                }

                LineChart(
                    start = 0f,
                    end = 6.3f,
                    sliceCount = 7,
                    entries = component.entries,
                    modifier = Modifier.padding(16.dp).weight(1f).fillMaxWidth(),
                )
            }

        }
    }

}