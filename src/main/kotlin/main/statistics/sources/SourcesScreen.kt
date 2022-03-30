package main.statistics.sources

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import main.statistics.compose.HorizontalBarChart
import main.statistics.compose.LineChart
import main.statistics.compose.VerticalBarChart

@Composable
fun SourcesScreen(component: SourcesComponent) {

    Column (
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row {
            Card(
                modifier = Modifier.padding(16.dp).weight(1f).aspectRatio(1.3f),
                elevation = 2.dp,
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {

                    Text(
                        text = "Записи",
                        style = MaterialTheme.typography.h5,
                    )
                    Text(
                        text = "Общее количество за выбранный период",
                        style = MaterialTheme.typography.subtitle1,
                    )

                    HorizontalBarChart(
                        start = 0f,
                        end = 14f,
                        sliceCount = 7,
                        color = Color(red = 147, green = 212, blue = 125),
                        entries = component.reservations,
                        modifier = Modifier.padding(16.dp).weight(1f).fillMaxWidth(),
                    )
                }
            }

            Card(
                modifier = Modifier.padding(16.dp).weight(1f).aspectRatio(1.3f),
                elevation = 2.dp,
            ) {

                Column(
                    modifier = Modifier.fillMaxSize().padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {

                    Text(
                        text = "Оборот",
                        style = MaterialTheme.typography.h5,
                    )
                    Text(
                        text = "Общее количество за выбранный период",
                        style = MaterialTheme.typography.subtitle1,
                    )

                    VerticalBarChart(
                        start = 0f,
                        end = 250000f,
                        sliceCount = 5,
                        color = Color(red = 152, green = 200, blue = 250),
                        entries = component.revenue,
                        modifier = Modifier.padding(16.dp).weight(1f).fillMaxWidth(),
                    )
                }
            }

        }

        Card(
            modifier = Modifier.padding(16.dp).fillMaxWidth().aspectRatio(2f),
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