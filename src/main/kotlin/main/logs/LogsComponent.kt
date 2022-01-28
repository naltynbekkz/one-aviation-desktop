package main.logs

import core.Component
import kotlinx.coroutines.flow.Flow

interface LogsComponent : Component {
    fun getData(): Flow<List<Log>>
}