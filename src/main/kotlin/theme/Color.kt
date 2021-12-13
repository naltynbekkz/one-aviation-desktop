package theme

import androidx.compose.material.Colors
import androidx.compose.material.LocalElevationOverlay
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

val froly = Color(0xFFFF6972)
val darkFroly = Color(0xFFEC515A)

val green = Color(0xFF1CD44C)
val darkGreen = Color(0xFF4CAF50)

val gray100 = Color(0xFFF5F5F5)

fun blendColors(first: Color, second: Color): Color {
    return Color(
        red = first.red * first.alpha + second.red * second.alpha,
        green = first.green * first.alpha + second.green * second.alpha,
        blue = first.blue * first.alpha + second.blue * second.alpha,
    )
}

@Composable
fun Colors.elevatedSurface(elevation: Dp): Color {
    return LocalElevationOverlay.current?.apply(
        color = this.surface,
        elevation = elevation
    ) ?: this.surface
}