package main.logs.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import core.slideFade
import main.logs.logs.LogsComponent
import main.logs.logs.LogsScreen
import main.logs.newReservation.NewReservationComponent
import main.logs.newReservation.NewReservationScreen
import main.logs.reservation.ReservationComponent
import main.logs.reservation.ReservationScreen

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun LogsNavigation(component: LogsNavigationComponent) {

    val routerState by component.routerState.subscribeAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Children(routerState = routerState, animation = slideFade()) {
            when (val child = it.instance) {
                is LogsComponent -> LogsScreen(
                    component = child,
                    goToReservation = { id ->
                        component.navigateToScreen(LogsDestination.Reservation(id))
                    },
                    makeAReservation = { calendar ->
                        component.navigateToScreen(LogsDestination.NewReservation(calendar))
                    },
                )
                is ReservationComponent -> ReservationScreen(child, component::navigateUp)
                is NewReservationComponent -> NewReservationScreen(child, component::navigateUp)
            }
        }
    }
}