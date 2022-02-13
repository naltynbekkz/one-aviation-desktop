package main.statistics.sources

import com.arkivanov.decompose.ComponentContext

class SourcesComponentImpl(
    componentContext: ComponentContext,
) : SourcesComponent, ComponentContext by componentContext