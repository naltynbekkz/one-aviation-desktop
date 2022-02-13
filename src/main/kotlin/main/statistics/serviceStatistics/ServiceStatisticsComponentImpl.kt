package main.statistics.serviceStatistics

import com.arkivanov.decompose.ComponentContext

class ServiceStatisticsComponentImpl(
    componentContext: ComponentContext,
) : ServiceStatisticsComponent, ComponentContext by componentContext