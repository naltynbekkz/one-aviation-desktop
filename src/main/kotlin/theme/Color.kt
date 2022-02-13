package theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val froly = Color(0xFFFF6972)
val darkFroly = Color(0xFFEC515A)

val green = Color(0xFF1CD44C)
val darkGreen = Color(0xFF4CAF50)

val Colors.gray100: Color get() = if (isLight) Color(0xFFF5F5F5) else Color(0xFF282828)
val Colors.gray200: Color get() = if (isLight) Color(0xFFEAEAEA) else Color(0xFF56565D)
val Colors.gray300: Color get() = if (isLight) Color(0xFFE0E0E0) else Color(0xFF505050)
val Colors.gray400: Color get() = if (isLight) Color(0xFFC2C2C2) else Color(0xFF777777)
val Colors.gray500: Color get() = if (isLight) Color(0xFFA9A9A9) else Color(0xFFA0A0A0)
val Colors.gray600: Color get() = if (isLight) Color(0xFF848484) else Color(0xFFBBBBBB)
val Colors.gray900: Color get() = if (isLight) Color(0xFF323232) else Color(0xFFF0F0F0)