import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
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

    val properties = Properties()

    try {
        val input = FileInputStream("apikey.properties")
        properties.load(input)
    } catch (e: Exception) {
        println("No such file: apikey.properties")
    }

    val apiKey: String = properties["ZAPIS_API_KEY"] as String? ?: ""


    val settingsProviderImpl = SettingsProviderImpl(Preferences.userRoot().node("one-aviation.prefs"))
    val repositoryProviderImpl = RepositoryProviderImpl(apiKey, 1, settingsProviderImpl.get())

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

            val windowState = rememberWindowState(WindowPlacement.Fullscreen)
            LifecycleController(lifecycle, windowState)

            Window(
                onCloseRequest = ::exitApplication,
                state = windowState,
                title = "One Aviation"
            ) {

                val mainSettings = settingsProviderImpl.get<MainSettings>()
                val nightMode by mainSettings.nightMode.collectAsState()

                OneAviationTheme(nightMode) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        RootContent(root = root, modifier = Modifier.fillMaxSize())
                    }
                }
            }
        }
    }
}
