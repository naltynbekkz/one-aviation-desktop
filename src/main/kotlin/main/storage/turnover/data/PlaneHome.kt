package main.storage.turnover.data

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp

@Composable
fun PlaneHomeContent() {
    val planes = remember { PlaneProvider.planeList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = planes,
            itemContent = {
                PlaneListItem(plane = it)
            }
        )
    }
}