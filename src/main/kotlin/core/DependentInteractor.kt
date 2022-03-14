package core

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import network.ResponseState

class DependentInteractor<T, S>(
    private val scope: CoroutineScope,
    flow: Flow<S>,
    private val fetchData: suspend (S) -> ResponseState.NetworkResponse<T>,
) {

    private val _isLoading = MutableStateFlow(true)
    private val _response = MutableStateFlow<ResponseState.NetworkResponse<T>?>(null)
    val isLoading = _isLoading.asStateFlow()
    val response = _response.asStateFlow()

    private var currentJob: Job? = null
    private var lastParam: S? = null

    init {
        flow
            .onEach {
                if (it != lastParam) {
                    lastParam = it
                    fetchData()
                }
            }
            .launchIn(scope)
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
            _response.value = fetchData.invoke(lastParam!!)
            _isLoading.value = false
        }
    }

    val data: T? get() = (response.value as? ResponseState.NetworkResponse.Success)?.data

    companion object {
        fun <T, S> ComponentContext.getDependentInteractor(
            flow: Flow<S>,
            fetchData: suspend (S) -> ResponseState.NetworkResponse<T>,
        ) = DependentInteractor(scope, flow, fetchData)
    }

}