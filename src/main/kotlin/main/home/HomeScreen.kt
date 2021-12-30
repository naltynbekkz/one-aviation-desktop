package main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(homeComponent: HomeComponent) {

    val scrollState = rememberScrollState()

    val modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp, vertical = 20.dp)

    Column(modifier = Modifier.fillMaxWidth().verticalScroll(scrollState)) {
        Hello(modifier)
        ReservationsAndNotes(modifier)
        Leadogeneration(modifier)
        UpdatesAndStatistics(modifier)
        Balance(modifier)
    }
}



@Composable
fun Hello(modifier: Modifier = Modifier) {
    Box(modifier.height(250.dp).background(Color(0xFF518DF4)))
}

@Composable
fun ReservationsAndNotes(modifier: Modifier = Modifier) {
    Box(modifier.height(250.dp).background(Color.Gray))
}

@Composable
fun Leadogeneration(modifier: Modifier = Modifier) {
    Box(modifier.height(50.dp).background(Color.Gray))
}

@Composable
fun UpdatesAndStatistics(modifier: Modifier = Modifier) {
    Box(modifier.height(250.dp).background(Color.Gray))
}

