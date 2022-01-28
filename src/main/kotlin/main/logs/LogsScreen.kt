package main.logs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun LogsScreen(logsComponent: LogsComponent) {

    val logs by logsComponent.getData().collectAsState(listOf())

    LazyColumn(
        contentPadding = PaddingValues(12.dp),
    ) {


    }
}