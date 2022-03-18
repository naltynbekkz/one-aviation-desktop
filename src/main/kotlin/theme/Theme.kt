package theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color

@Composable
fun OneAviationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val primary by animateColorAsState(if (darkTheme) darkFroly else froly)
    val primaryVariant by animateColorAsState(if (darkTheme) Color(0xFF3700B3) else Color(0xFF3700B3))
    val secondary by animateColorAsState(if (darkTheme) darkGreen else green)
    val secondaryVariant by animateColorAsState(if (darkTheme) Color(0xFF03DAC6) else Color(0xFF018786))
    val background by animateColorAsState(if (darkTheme) Color(0xFF121212) else Color.White)
    val surface by animateColorAsState(if (darkTheme) Color(0xFF121212) else Color.White)
    val error by animateColorAsState(if (darkTheme) Color(0xFFCF6679) else Color(0xFFB00020))
    val onPrimary by animateColorAsState(if (darkTheme) Color.Black else Color.White)
    val onSecondary by animateColorAsState(if (darkTheme) Color.Black else Color.Black)
    val onBackground by animateColorAsState(if (darkTheme) Color.White else Color.Black)
    val onSurface by animateColorAsState(if (darkTheme) Color.White else Color.Black)
    val onError by animateColorAsState(if (darkTheme) Color.Black else Color.White)

    val colors = Colors(
        primary = primary,
        primaryVariant = primaryVariant,
        secondary = secondary,
        secondaryVariant = secondaryVariant,
        background = background,
        surface = surface,
        error = error,
        onPrimary = onPrimary,
        onSecondary = onSecondary,
        onBackground = onBackground,
        onSurface = onSurface,
        onError = onError,
        isLight = !darkTheme,
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}