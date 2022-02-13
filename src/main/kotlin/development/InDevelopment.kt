@file:JvmName("InDevelopmentComponentKt")

package development

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun InDevelopment(inDevelopment: InDevelopmentComponent) {
    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Text("This screen is currently in development")
    }
}