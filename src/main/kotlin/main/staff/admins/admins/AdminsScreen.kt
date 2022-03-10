package main.staff.admins.admins

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.unit.dp
import core.EmptyResponseHandler
import core.ResponseComponent

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun AdminsScreen(
    component: AdminsComponent,
    addAdmin: () -> Unit,
    goToAdmin: (Long) -> Unit,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Admins")
                },
                backgroundColor = MaterialTheme.colors.background,
                actions = {
                    TextButton(onClick = {
                        addAdmin()
                    }) {
                        Text("Add admin")
                    }
                    IconButton(onClick = {
                        component.admins.refresh()
                    }) {
                        Icon(Icons.Default.Refresh, null)
                    }
                }
            )
        }
    ) {
        Column {
            ResponseComponent(
                interactor = component.admins,
                emptyResponseHandler = EmptyResponseHandler(
                    title = "There are no admins",
                    subtitle = null,
                    isEmpty = { it.isEmpty() })
            ) {

                LazyVerticalGrid(
                    cells = GridCells.Adaptive(200.dp),
                    contentPadding = PaddingValues(12.dp),
                ) {

                    items(it) { admin ->

                        var elevated by remember { mutableStateOf(false) }
                        val elevation = remember(elevated) { if (elevated) 8.dp else 4.dp }
                        val animatedElevation by animateDpAsState(elevation)

                        Card(
                            modifier = Modifier
                                .padding(12.dp)
                                .fillMaxWidth()
                                .aspectRatio(0.75f)
                                .pointerMoveFilter(
                                    onEnter = { elevated = true; true },
                                    onExit = { elevated = false; true },
                                    onMove = { true }
                                )
                                .clickable {
                                    goToAdmin(admin.id)
                                },
                            shape = RoundedCornerShape(4.dp),
                            elevation = animatedElevation,
                        ) {
                            Column(Modifier.fillMaxSize()) {
                                Card(
                                    modifier = Modifier
                                        .padding(12.dp)
                                        .fillMaxWidth()
                                        .aspectRatio(1f),
                                    shape = RectangleShape,
                                    elevation = 12.dp,
                                ) {

                                }
                                Text(
                                    text = admin.firstName + " " + admin.lastName,
                                    modifier = Modifier.padding(12.dp),
                                    maxLines = 2,
                                )
                            }
                        }
                    }
                }
            }
        }
    }


}