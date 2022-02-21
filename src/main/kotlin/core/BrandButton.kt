package core

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
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
fun LoadingGreenButton(
    text: String,
    isLoading: Boolean,
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
            if (isLoading) {
                CircularProgressIndicator()
            } else {
                icon?.invoke()
                Text(
                    text = text,
                    fontSize = 16.sp,
                )
            }
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
        colors = buttonColors(MaterialTheme.colors.gray100, froly),
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