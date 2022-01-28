package main.logs

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class LogsComponentImpl(
    componentContext: ComponentContext,
) : LogsComponent, ComponentContext by componentContext {
    override fun getData(): Flow<List<Log>> = MutableStateFlow(listOf())
}