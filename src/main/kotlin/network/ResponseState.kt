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
}