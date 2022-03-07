package core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import network.ResponseState

@Composable
fun <T> ResponseComponent(
    interactor: Interactor<T>,
    emptyResponseHandler: EmptyResponseHandler<T>? = null,
    content: @Composable (T) -> Unit,
) {
    val response by interactor.response.collectAsState()
    val isLoading by interactor.isLoading.collectAsState()
    if (isLoading) {
        LazyColumn(Modifier.fillMaxSize()) {
            item {
                Box(Modifier.fillParentMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }
    } else {
        ResponseComponentImpl(
            response = response,
            emptyResponseHandler = emptyResponseHandler,
            content = content
        )
    }
}

@Composable
private fun <T> ResponseComponentImpl(
    response: ResponseState.NetworkResponse<T>?,
    emptyResponseHandler: EmptyResponseHandler<T>? = null,
    content: @Composable (T) -> Unit,
) {
    when (response) {
        is ResponseState.NetworkResponse.Success -> {
            if (emptyResponseHandler?.isEmpty?.invoke(response.data) == true) {
                ErrorPage(emptyResponseHandler)
            } else {
                content(response.data)
            }
        }
        is ResponseState.NetworkResponse.Error -> {
            val errorResponseHandler = when (response) {
                is ResponseState.NetworkResponse.Error.NetworkError -> ErrorResponseHandler(
                    title = "network error",
                    subtitle = "network error description",
                )
                is ResponseState.NetworkResponse.Error.ServerError, is ResponseState.NetworkResponse.Error.UnknownError -> ErrorResponseHandler(
                    title = "server error",
                    subtitle = "server error description",
                )
                else -> null
            }
            errorResponseHandler?.let { ErrorPage(it) }
        }
    }
}

class EmptyResponseHandler<T>(
    title: String,
    subtitle: String? = null,
    val isEmpty: (T) -> Boolean,
) : ErrorResponseHandler(title, subtitle)

open class ErrorResponseHandler(
    val title: String,
    val subtitle: String? = null,
)

@Composable
fun ErrorPage(errorResponseHandler: ErrorResponseHandler) {
    LazyColumn(Modifier.fillMaxSize()) {
        item {
            ErrorComponent(
                errorResponseHandler = errorResponseHandler,
                modifier = Modifier.fillParentMaxSize(),
            )
        }
    }
}

@Composable
fun ErrorComponent(
    errorResponseHandler: ErrorResponseHandler,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = errorResponseHandler.title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle1,
        )
        errorResponseHandler.subtitle?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.caption,
            )
        }
    }
}