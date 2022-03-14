package main.staff.admins.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import core.slideFade
import main.staff.admins.addAdmin.AddAdminComponent
import main.staff.admins.addAdmin.AddAdminScreen
import main.staff.admins.admin.AdminComponent
import main.staff.admins.admin.AdminScreen
import main.staff.admins.admins.AdminsComponent
import main.staff.admins.admins.AdminsScreen

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun AdminsNavigation(component: AdminsNavigationComponent) {

    val routerState by component.routerState.subscribeAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Children(routerState = routerState, animation = slideFade()) {
            when (val child = it.instance) {
                is AdminsComponent -> AdminsScreen(
                    component = child,
                    addAdmin = {
                        component.navigateToScreen(AdminsDestination.AddAdmin)
                    },
                    goToAdmin = { id ->
                        component.navigateToScreen(AdminsDestination.Admin(id))
                    }
                )
                is AdminComponent -> AdminScreen(
                    component = child,
                    navigateUp = component::navigateUp,
                )
                is AddAdminComponent -> AddAdminScreen(
                    component = child,
                    navigateUp = component::navigateUp,
                )
            }
        }
    }
}