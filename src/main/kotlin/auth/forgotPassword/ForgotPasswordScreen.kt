package auth.forgotPassword

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ForgotPasswordScreen(
    forgotPasswordComponent: ForgotPasswordComponent,
    navigateUp: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button({
            navigateUp()
        }) {
            Text("back")
        }
    }
}