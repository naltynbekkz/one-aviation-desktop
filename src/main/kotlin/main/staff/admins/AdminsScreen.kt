package main.staff.admins

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun AdminsScreen(component: AdminsComponent) {

    LazyVerticalGrid(
        cells = GridCells.Adaptive(200.dp),
        contentPadding = PaddingValues(12.dp),
    ) {

        items(10) {

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
                    ),
                shape = RoundedCornerShape(4.dp),
                elevation = animatedElevation,
            ) {
                Box(Modifier.fillMaxSize()) {
                    Card(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        shape = RectangleShape,
                        elevation = 12.dp,
                    ) {

                    }
                }
            }
        }
    }
}