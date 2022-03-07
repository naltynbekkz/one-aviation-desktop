package main.staff.masters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import core.EmptyResponseHandler
import core.ResponseComponent
import main.staff.masters.data.PlaneListItem

@Composable
fun MastersScreen(
    component: MastersComponent,
    addMaster: () -> Unit,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Planes")
                },
                backgroundColor = MaterialTheme.colors.background,
                actions = {
                    TextButton(onClick = {
                        addMaster()
                    }) {
                        Text("Add plane")
                    }
                    IconButton(onClick = {
                        component.list.refresh()
                    }) {
                        Icon(Icons.Default.Refresh, null)
                    }
                }
            )
        }
    ) {
        Column {
            ResponseComponent(
                interactor = component.list,
                emptyResponseHandler = EmptyResponseHandler(
                    title = "There are no planes",
                    subtitle = null,
                    isEmpty = { it.isEmpty() })
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(
                        items = it,
                        itemContent = {
                            PlaneListItem(plane = it)
                        }
                    )
                }
            }
        }
    }
}