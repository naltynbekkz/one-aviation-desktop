import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.window.*
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import main.MainSettings
import network.RepositoryProviderImpl
import root.RootComponentImpl
import root.RootContent
import settings.SettingsProviderImpl
import settings.get
import theme.OneAviationTheme
import java.io.FileInputStream
import java.util.*
import java.util.prefs.Preferences

@OptIn(ExperimentalDecomposeApi::class)
fun main() {

    val title = "One Aviation"

    val properties = Properties()

    try {
        val input = FileInputStream("apikey.properties")
        properties.load(input)
    } catch (e: Exception) {
        println("No such file: apikey.properties")
    }

    val settingsProviderImpl = SettingsProviderImpl(Preferences.userRoot().node("one-aviation.prefs"))
    val repositoryProviderImpl = RepositoryProviderImpl("apiKey", 1, settingsProviderImpl.get())

    val lifecycle = LifecycleRegistry()
    val root = RootComponentImpl(
        repositoryProviderImpl,
        settingsProviderImpl,
        DefaultComponentContext(lifecycle),
    )

    application {

        DisposableEffect(settingsProviderImpl) {
            settingsProviderImpl.start()
            onDispose {
                settingsProviderImpl.stop()
            }
        }

        CompositionLocalProvider(
            LocalScrollbarStyle provides defaultScrollbarStyle(),
        ) {

            var isVisible by remember { mutableStateOf(true) }

            val windowState = rememberWindowState(WindowPlacement.Maximized)
            LifecycleController(lifecycle, windowState)

            Window(
                onCloseRequest = {
                    if (isTraySupported) {
                        isVisible = false
                    } else {
                        exitApplication()
                    }
                },
                state = windowState,
                visible = isVisible,
                title = title,
            ) {

                val mainSettings = settingsProviderImpl.get<MainSettings>()
                val nightMode by mainSettings.nightMode.collectAsState()

                OneAviationTheme(nightMode) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        RootContent(root = root, modifier = Modifier.fillMaxSize())
                    }
                }
            }

            if (isTraySupported) {
                val state = rememberTrayState()
                Tray(
                    icon = TrayIcon,
                    state = state,
                    tooltip = title,
                    onAction = {
                        isVisible = true
                    },
                    menu = {
                        Item("Show One Aviation") {
                            isVisible = true
                        }
                        Item("notification") {
                            state.sendNotification(Notification("Attention", "Bowser escped", Notification.Type.Info))
                        }
                        Item("Exit", onClick = ::exitApplication)
                    }
                )
            }
        }
    }
}

object TrayIcon : Painter() {
    override val intrinsicSize = Size(256f, 256f)

    override fun DrawScope.onDraw() {
        drawOval(Color(0xFFFFA500))
    }
}