package core

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import network.ResponseState

class Interactor<T>(
    private val scope: CoroutineScope,
    initialValue: T?,
    private val fetchData: suspend () -> ResponseState.NetworkResponse<T>,
) {

    private val _response = MutableStateFlow<ResponseState<T>>(ResponseState.Loading(initialValue))
    val response get() = _response.asStateFlow()

    private var currentJob: Job? = null

    init {
        fetchData()
    }

    fun refresh() {
        if (_response.value !is ResponseState.Loading) {
            _response.value = ResponseState.Loading()
            fetchData()
        }
    }

    private fun fetchData() {
        currentJob?.cancel()
        currentJob = scope.launch {
            _response.value = fetchData.invoke()
        }
    }

    fun setData(data: T) {
        currentJob?.cancel()
        this._response.value = ResponseState.NetworkResponse.Success(data)
    }

    val data: T? get() = (response.value as? ResponseState.NetworkResponse.Success)?.data

    companion object {
        fun <T> ComponentContext.getInteractor(
            initialValue: T? = null,
            fetchData: suspend () -> ResponseState.NetworkResponse<T>,
        ) = Interactor(scope, initialValue, fetchData)
    }

}