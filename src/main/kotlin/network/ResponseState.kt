package network

sealed class ResponseState<out T>(open val data: T? = null) {
    class Loading<out T>(data: T? = null) : ResponseState<T>(data)

    sealed class NetworkResponse<out T>(data: T? = null) : ResponseState<T>(data) {

        private var new = true

        fun isNew(): Boolean {
            return if (new) {
                new = false
                true
            } else false
        }

        class Success<out T>(override val data: T) : NetworkResponse<T>()
        sealed class Error<out T>(data: T? = null) : NetworkResponse<T>(data) {
            class UnknownError<T>(exception: Exception? = null, data: T? = null) : Error<T>(data)
            class CancelledError<T>(data: T? = null) : Error<T>(data)
            class UnauthenticatedError<T>(data: T? = null) : Error<T>(data)
            class NetworkError<T>(data: T? = null) : Error<T>(data)
            class ServerError<T>(data: T? = null) : Error<T>(data)
        }
    }

    companion object {
        fun <T, R> ResponseState<T>.convert(convert: (T) -> R): ResponseState<R> {
            return when (this) {
                is Loading -> Loading(data?.let(convert))
                is NetworkResponse -> this.convert(convert)
            }
        }

        fun <T, R> NetworkResponse<T>.convert(convert: (T) -> R): NetworkResponse<R> {
            return when (this) {
                is NetworkResponse.Error.UnknownError -> NetworkResponse.Error.UnknownError()
                is NetworkResponse.Error.UnauthenticatedError -> NetworkResponse.Error.UnauthenticatedError()
                is NetworkResponse.Error.NetworkError -> NetworkResponse.Error.NetworkError()
                is NetworkResponse.Error.ServerError -> NetworkResponse.Error.ServerError()
                is NetworkResponse.Error.CancelledError -> NetworkResponse.Error.CancelledError()
                is NetworkResponse.Success -> NetworkResponse.Success(convert(data))
            }
        }
    }

}