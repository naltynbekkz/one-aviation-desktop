package main.help.documentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import core.slideFade
import main.help.feedback.FeedbackComponent
import main.help.feedback.FeedbackScreen
import main.home.HomeComponent
import main.home.HomeScreen
import main.logs.logs.LogsComponent
import main.logs.logs.LogsScreen
import main.settings.SettingsComponent
import main.settings.SettingsScreen

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun DocumentationNavigation(component: DocumentationNavigationComponent) {

    val routerState by component.routerState.subscribeAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Children(routerState = routerState, animation = slideFade()) {
            when (val child = it.instance) {
                is DocumentationComponent -> DocumentationScreen(child)
            }
        }
    }
}