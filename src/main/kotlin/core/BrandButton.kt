package core

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.froly
import theme.gray100
import theme.green

@Composable
fun GreenButton(
    text: String,
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = buttonColors(green, Color.White),
        content = {
            icon?.invoke()
            Text(
                text = text,
                fontSize = 16.sp,
            )
        },
    )
}

@Composable
fun GrayButton(
    text: String,
    modifier: Modifier = Modifier,
    icon: ImageVector?,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = buttonColors(gray100, froly),
        content = {
            if (icon != null) {
                Icon(
                    icon,
                    contentDescription = "",
                    modifier = Modifier.size(16.dp),
                    tint = froly
                )
                Spacer(Modifier.width(4.dp))
            }
            Text(
                text = text,
                fontSize = 14.sp,
            )
        },
    )
}