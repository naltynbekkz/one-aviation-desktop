package main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.animation.child.crossfadeScale
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import development.InDevelopment
import development.InDevelopmentScreen
import main.home.HomeComponent
import main.home.HomeScreen
import main.profile.ProfileComponent
import main.profile.ProfileScreen
import main.settings.SettingsComponent
import main.settings.SettingsScreen

@OptIn(ExperimentalDecomposeApi::class, androidx.compose.ui.ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(mainComponent: MainComponent) {
    val routerState by mainComponent.routerState.subscribeAsState()
    val destinations by mainComponent.destinations.subscribeAsState()

    val selectedDestination = routerState.activeChild.configuration

    Row {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.primary.copy(alpha = 0.12f))
                .fillMaxHeight()
                .width(360.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            for (destination in destinations) {

                var elevated by remember { mutableStateOf(false) }

                val backgroundAlpha = remember(elevated, destination, selectedDestination) {
                    if (destination == selectedDestination) 0.12f else if (elevated) 0.06f else 0f
                }

                Row(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(
                            color = MaterialTheme.colors.primary.copy(alpha = backgroundAlpha),
                            shape = RoundedCornerShape(50)
                        )
                        .pointerMoveFilter(
                            onEnter = { elevated = true; true },
                            onExit = { elevated = false; true },
                            onMove = { true }
                        )
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            enabled = destination != selectedDestination,
                        ) {
                            mainComponent.navigateToScreen(destination)
                        },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(destination.title, Modifier.padding(horizontal = 16.dp))
//                    destination.screens.forEach {
//                        Text(it, modifier = Modifier.padding(start = 16.dp))
//                    }
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
        }

        Box(modifier = Modifier.weight(1f)) {
            Children(routerState = routerState, animation = crossfadeScale()) {
                when (val child = it.instance) {
                    is InDevelopment -> InDevelopmentScreen(child)
                    is SettingsComponent -> SettingsScreen(child)
                    is HomeComponent -> HomeScreen(child)
                    is ProfileComponent -> ProfileScreen(child)
                    else -> error("shouldn't be happening")
                }
            }
        }
    }
}