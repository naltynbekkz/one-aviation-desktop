package core

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import network.ResponseState

class NullableInteractor<T, S>(
    private val scope: CoroutineScope,
    private val fetchData: suspend (S) -> ResponseState.NetworkResponse<T>,
) {

    var lastQueryParam: S? = null

    private val _response = MutableStateFlow<ResponseState<T>?>(null)
    val response get() = _response.asStateFlow()

    private var currentJob: Job? = null

    fun refresh(newQueryParam: S? = null) {
        if (newQueryParam != null) {
            lastQueryParam = newQueryParam
        }
        if (lastQueryParam != null) {
            _response.value = ResponseState.Loading()
            fetchData()
        }
    }

    fun initialFetch(s: S) {
        lastQueryParam = s
        _response.value = ResponseState.Loading()
        fetchData()
    }

    private fun fetchData() {
        currentJob?.cancel()
        currentJob = scope.launch {
            _response.value = fetchData.invoke(lastQueryParam!!)
        }
    }

    fun cancel() {
        currentJob?.cancel()
        _response.value = null
    }

    fun setData(data: T) {
        currentJob?.cancel()
        this._response.value = ResponseState.NetworkResponse.Success(data)
    }

    val data: T? get() = (response.value as? ResponseState.NetworkResponse.Success)?.data

    companion object {
        fun <T, S> ComponentContext.getNullableInteractor(
            fetchData: suspend (S) -> ResponseState.NetworkResponse<T>,
        ) = NullableInteractor(scope, fetchData)
    }

}