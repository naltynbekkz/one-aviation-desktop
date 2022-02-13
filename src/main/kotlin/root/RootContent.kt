package root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import auth.AuthComponent
import auth.AuthScreen
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.animation.child.crossfadeScale
import main.MainComponent
import main.MainScreen

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun RootContent(root: RootComponent, modifier: Modifier = Modifier) {

    val token by root.refreshToken.collectAsState()

    LaunchedEffect(token) {
        if (token == null) {
            root.navigateToAuth()
        } else {
            root.navigateToMain()
        }
    }

    Children(routerState = root.routerState, animation = crossfadeScale()) {
        when (val child = it.instance) {
            is MainComponent -> MainScreen(child)
            is AuthComponent -> AuthScreen(child)
            else -> error("shouldn't be happening")
        }
    }

}