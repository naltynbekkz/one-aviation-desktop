package main.staff.masters.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import core.slideFade
import main.staff.masters.masters.MastersComponent
import main.staff.masters.masters.MastersScreen
import main.staff.masters.addMaster.AddMasterComponent
import main.staff.masters.addMaster.AddMasterScreen

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun MastersNavigation(component: MastersNavigationComponent) {

    val routerState by component.routerState.subscribeAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Children(routerState = routerState, animation = slideFade()) {
            when (val child = it.instance) {
                is MastersComponent -> MastersScreen(
                    component = child,
                    addMaster = { component.navigateToScreen(MastersDestination.AddMaster) },
                )
                is AddMasterComponent -> AddMasterScreen(
                    component = child,
                    navigateUp = component::navigateUp
                )
            }
        }
    }
}