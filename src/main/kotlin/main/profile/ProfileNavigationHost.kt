package main.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.animation.child.crossfadeScale
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import development.InDevelopment
import development.InDevelopmentScreen
import main.profile.changePassword.ChangePasswordComponent
import main.profile.changePassword.ChangePasswordScreen
import main.profile.profile.ProfileScreen
import main.profile.profile.ProfileScreenComponent

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun ProfileNavigationHost(profileComponent: ProfileComponent) {

    val routerState by profileComponent.routerState.subscribeAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Children(routerState = routerState, animation = crossfadeScale()) {
            when (val child = it.instance) {
                is InDevelopment -> InDevelopmentScreen(child)
                is ChangePasswordComponent -> ChangePasswordScreen(child, profileComponent::navigateUp)
                is ProfileScreenComponent -> ProfileScreen(child) {
                    profileComponent.navigateToScreen(ProfileDestination.ChangePassword)
                }
                else -> error("shouldn't be happening")
            }
        }
    }
}