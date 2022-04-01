package core

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

    private val _isLoading = MutableStateFlow(true)
    private val _response =
        MutableStateFlow<ResponseState.NetworkResponse<T>?>(initialValue?.let { ResponseState.NetworkResponse.Success(it) })
    val isLoading = _isLoading.asStateFlow()
    val response = _response.asStateFlow()

    private var currentJob: Job? = null

    init {
        fetchData()
    }

    fun refresh() {
        if (!_isLoading.value) {
            fetchData()
        }
    }

    private fun fetchData() {
        _isLoading.value = true
        currentJob?.cancel()
        currentJob = scope.launch {
            _response.value = fetchData.invoke()
            _isLoading.value = false
        }
    }

    val data: T? get() = (response.value as? ResponseState.NetworkResponse.Success)?.data

    companion object {
        fun <T> CustomComponentContext.getInteractor(
            initialValue: T? = null,
            fetchData: suspend () -> ResponseState.NetworkResponse<T>,
        ) = Interactor(scope, initialValue, fetchData)
    }

}