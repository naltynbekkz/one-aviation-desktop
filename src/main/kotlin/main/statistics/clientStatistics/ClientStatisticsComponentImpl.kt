package main.statistics.clientStatistics

import com.arkivanov.decompose.ComponentContext

class ClientStatisticsComponentImpl(
    componentContext: ComponentContext,
) : ClientStatisticsComponent, ComponentContext by componentContext