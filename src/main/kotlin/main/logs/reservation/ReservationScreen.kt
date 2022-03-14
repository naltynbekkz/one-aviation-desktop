package main.logs.reservation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import core.ResponseComponent

@Composable
fun ReservationScreen(
    component: ReservationComponent,
    navigateUp: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Flight")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back button",
                            tint = MaterialTheme.colors.primary,
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.background,
                actions = {
                    IconButton(onClick = {
                        component.flight.refresh()
                    }) {
                        Icon(Icons.Default.Refresh, null)
                    }
                }
            )
        }
    ) {
        ResponseComponent(
            interactor = component.flight,
        ) { flight ->
            Text(flight.toString())
        }
    }

}