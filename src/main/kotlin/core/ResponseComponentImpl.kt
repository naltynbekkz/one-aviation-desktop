package core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import network.ResponseState

@Composable
private fun <T> ResponseComponentImpl(
    isLoading: Boolean,
    response: ResponseState.NetworkResponse<T>?,
    content: @Composable (T) -> Unit,
) {
    when (response) {
        null -> {
            if (isLoading) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }
        is ResponseState.NetworkResponse.Success -> {
            content(response.data)
        }
        is ResponseState.NetworkResponse.Error -> {
            ErrorComponent(
                text = "Unknown Error",
            )
        }
    }
}

@Composable
fun ErrorComponent(
    text: String,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = text)
    }
}