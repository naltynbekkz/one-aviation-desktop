package main.staff.masters.masters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.EmptyResponseHandler
import core.ResponseComponent
import main.staff.masters.data.Plane
import theme.typography

@Composable
fun MastersScreen(
    component: MastersComponent,
    navigateToMaster: (Long) -> Unit,
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
                            PlaneListItem(plane = it, onClick = { navigateToMaster(it.id) })
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun PlaneListItem(plane: Plane, onClick: () -> Unit) {

    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxWidth().clickable(onClick = onClick),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxWidth().align(Alignment.CenterVertically)
            ) {
                Text(text = plane.name, style = typography.h6)
                Text(text = "Capacity ${plane.capacity}", style = typography.caption)
            }
        }
    }
}