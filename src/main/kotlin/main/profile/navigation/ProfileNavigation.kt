package main.profile.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import core.slideFade
import main.profile.ProfileDestination
import main.profile.changePassword.ChangePasswordComponent
import main.profile.changePassword.ChangePasswordScreen
import main.profile.editProfile.EditProfileComponent
import main.profile.editProfile.EditProfileScreen
import main.profile.profile.ProfileComponent
import main.profile.profile.ProfileScreen

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun ProfileNavigation(component: ProfileNavigationComponent) {

    val routerState by component.routerState.subscribeAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Children(routerState = routerState, animation = slideFade()) {
            when (val child = it.instance) {
                is ProfileComponent -> ProfileScreen(child,
                    navigateToChangePassword = { component.navigateToScreen(ProfileDestination.ChangePassword) },
                    navigateToEditProfile = { component.navigateToScreen(ProfileDestination.EditProfile) }
                )
                is ChangePasswordComponent -> ChangePasswordScreen(child) {
                    component.navigateUp()
                }
                is EditProfileComponent -> EditProfileScreen(child) { component.navigateUp() }
            }
        }
    }
}