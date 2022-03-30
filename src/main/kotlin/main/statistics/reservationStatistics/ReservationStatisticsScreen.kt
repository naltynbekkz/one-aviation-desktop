package main.statistics.reservationStatistics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import main.statistics.compose.HorizontalBarChart
import main.statistics.compose.VerticalBarChart

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReservationStatisticsScreen(component: ReservationStatisticsComponent) {

    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        cells = GridCells.Adaptive(600.dp),
    ) {
        item {
            Card(
                modifier = Modifier
                    .padding(24.dp)
                    .requiredHeight(400.dp)
                    .fillMaxWidth(),
                elevation = 4.dp,
            ) {

            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(24.dp)
                    .requiredHeight(400.dp)
                    .fillMaxWidth(),
                elevation = 4.dp,
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {

                    Text(
                        text = "Оборот",
                        style = MaterialTheme.typography.h6,
                    )

                    VerticalBarChart(
                        start = 0f,
                        end = 7500f,
                        sliceCount = 5,
                        color = Color(red = 152, green = 200, blue = 250),
                        entries = component.revenueEntries,
                        modifier = Modifier.padding(16.dp).weight(1f).fillMaxWidth(),
                    )

                }
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(24.dp)
                    .requiredHeight(400.dp)
                    .fillMaxWidth(),
                elevation = 4.dp,
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {

                    Text(
                        text = "Количество записей по мастерам",
                        style = MaterialTheme.typography.h6,
                    )

                    HorizontalBarChart(
                        start = 0f,
                        end = 4f,
                        sliceCount = 4,
                        color = Color(red = 152, green = 200, blue = 250),
                        entries = component.mastersReservationsEntries,
                        modifier = Modifier.padding(16.dp).weight(1f).fillMaxWidth(),
                    )

                }
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(24.dp)
                    .requiredHeight(400.dp)
                    .fillMaxWidth(),
                elevation = 4.dp,
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {

                    Text(
                        text = "Оборот по мастерам",
                        style = MaterialTheme.typography.h6,
                    )

                    HorizontalBarChart(
                        start = 0f,
                        end = 14250f,
                        sliceCount = 5,
                        color = Color(red = 147, green = 212, blue = 125),
                        entries = component.mastersRevenueEntries,
                        modifier = Modifier.padding(16.dp).weight(1f).fillMaxWidth(),
                    )

                }
            }
        }
    }

}