package main.statistics.reservationStatistics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import main.statistics.compose.BarChart

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
                BarChart(
                    start = 0f,
                    end = 0f,
                    sliceCount = 1,
                    entries = listOf(),
                )
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
                BarChart(
                    start = 0f,
                    end = 0f,
                    sliceCount = 1,
                    entries = listOf(),
                )
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
                BarChart(
                    start = 0f,
                    end = 0f,
                    sliceCount = 1,
                    entries = listOf(),
                )
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
                BarChart(
                    start = 0f,
                    end = 0f,
                    sliceCount = 1,
                    entries = listOf(),
                )
            }
        }
    }

}